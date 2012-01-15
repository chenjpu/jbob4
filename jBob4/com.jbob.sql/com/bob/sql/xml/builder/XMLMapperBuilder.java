
package com.bob.sql.xml.builder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.bob.sql.xml.Configuration;
import com.bob.sql.xml.mapping.ParameterMapping;
import com.bob.sql.xml.parsing.XNode;
import com.bob.sql.xml.parsing.XPathParser;
import com.bob.sql.xml.type.JdbcType;

public class XMLMapperBuilder extends BaseBuilder {

	private XPathParser parser;
	private MapperBuilderAssistant builderAssistant;
	private String resource;

	public XMLMapperBuilder(InputStream inputStream, Configuration configuration, String resource, String namespace) {
		this(inputStream, configuration, resource);
		this.builderAssistant.setCurrentNamespace(namespace);
	}

	public XMLMapperBuilder(InputStream inputStream, Configuration configuration, String resource) {
		this(new XPathParser(inputStream, true, configuration.getVariables(), new XMLMapperEntityResolver()), configuration, resource);
	}

	private XMLMapperBuilder(XPathParser parser, Configuration configuration, String resource) {
		super(configuration);
		this.builderAssistant = new MapperBuilderAssistant(configuration, resource);
		this.parser = parser;
		this.resource = resource;
	}

	public Configuration parse() {
		if (!configuration.isResourceLoaded(resource)) {
			configurationElement(parser.evalNode("/mapper"));
			configuration.addLoadedResource(resource);
		}
		return configuration;
	}

	private void configurationElement(XNode context) {
		try {
			String namespace = context.getStringAttribute("namespace");
			builderAssistant.setCurrentNamespace(namespace);
			//cacheRefElement(context.evalNode("cache-ref"));
			//cacheElement(context.evalNode("cache"));
			parameterMapElement(context.evalNodes("/mapper/parameterMap"));
			buildStatementFromContext(context.evalNodes("pageable|select|insert|update|delete"));
			//buildStatementFromContext(context.evalNodes("select"));
		} catch (Exception e) {
			throw new RuntimeException("Error parsing Mapper XML. Cause: " + e, e);
		}
	}

	private void buildStatementFromContext(List<XNode> list) {
		for (XNode context : list) {
			final XMLStatementBuilder statementParser = new XMLStatementBuilder(configuration, builderAssistant, context);
			statementParser.parseStatementNode();
		}
	}

	private void parameterMapElement(List<XNode> list) throws Exception {
		for (XNode parameterMapNode : list) {
			String id = parameterMapNode.getStringAttribute("id");
			String type = parameterMapNode.getStringAttribute("type");
			Class<?> parameterClass = resolveClass(type);
			List<XNode> parameterNodes = parameterMapNode.evalNodes("parameter");
			List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();
			for (XNode parameterNode : parameterNodes) {
				String property = parameterNode.getStringAttribute("property");
				String javaType = parameterNode.getStringAttribute("javaType");
				String jdbcType = parameterNode.getStringAttribute("jdbcType");
				Integer numericScale = parameterNode.getIntAttribute("numericScale", null);
				//ParameterMode modeEnum = resolveParameterMode(mode);
				Class<?> javaTypeClass = resolveClass(javaType);
				JdbcType jdbcTypeEnum = resolveJdbcType(jdbcType);
				ParameterMapping parameterMapping = builderAssistant.buildParameterMapping(parameterClass, property, javaTypeClass,
						jdbcTypeEnum, numericScale);
				parameterMappings.add(parameterMapping);
			}
			builderAssistant.addParameterMap(id, parameterClass, parameterMappings);
		}
	}

}
