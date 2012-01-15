
package com.bob.sql.xml.builder;

import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import com.bob.sql.xml.Configuration;
import com.bob.sql.xml.ErrorContext;
import com.bob.sql.xml.io.Resources;
import com.bob.sql.xml.parsing.BuilderException;
import com.bob.sql.xml.parsing.XNode;
import com.bob.sql.xml.parsing.XPathParser;
import com.bob.sql.xml.reflection.MetaClass;

public class XMLConfigBuilder extends BaseBuilder {

	private boolean parsed;
	private XPathParser parser;

	public XMLConfigBuilder(Reader reader) {
		this(reader, null);
	}

	public XMLConfigBuilder(Reader reader, Properties props) {
		this(new XPathParser(reader, true, props, new XMLMapperEntityResolver()), props);
	}

	public XMLConfigBuilder(InputStream inputStream) {
		this(inputStream, null);
	}

	public XMLConfigBuilder(InputStream inputStream, Properties props) {
		this(new XPathParser(inputStream, true, props, new XMLMapperEntityResolver()), props);
	}

	private XMLConfigBuilder(XPathParser parser, Properties props) {
		super(new Configuration());
		ErrorContext.instance().resource("SQL Mapper Configuration");
		this.configuration.setVariables(props);
		this.parsed = false;
		this.parser = parser;
	}

	public Configuration parse() {
		if (parsed) {
			throw new BuilderException("Each MapperConfigParser can only be used once.");
		}
		parsed = true;
		parseConfiguration(parser.evalNode("/configuration"));
		return configuration;
	}

	private void parseConfiguration(XNode root) {
		try {
			typeAliasesElement(root.evalNode("typeAliases"));
			propertiesElement(root.evalNode("properties"));
			settingsElement(root.evalNode("settings"));
			mapperElement(root.evalNode("mappers"));
		} catch (Exception e) {
			throw new BuilderException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
		}
	}

	private void typeAliasesElement(XNode parent) {
		if (parent != null) {
			for (XNode child : parent.getChildren()) {
				if ("package".equals(child.getName())) {
					String typeAliasPackage = child.getStringAttribute("name");
					configuration.getTypeAliasRegistry().registerAliases(typeAliasPackage);
				} else {
					String alias = child.getStringAttribute("alias");
					String type = child.getStringAttribute("type");
					try {
						Class<?> clazz = Resources.classForName(type);
						if (alias == null) {
							typeAliasRegistry.registerAlias(clazz);
						} else {
							typeAliasRegistry.registerAlias(alias, clazz);
						}
					} catch (ClassNotFoundException e) {
						throw new BuilderException("Error registering typeAlias for '" + alias + "'. Cause: " + e, e);
					}
				}
			}
		}
	}

	private void propertiesElement(XNode context) throws Exception {
		if (context != null) {
			Properties defaults = context.getChildrenAsProperties();
			String resource = context.getStringAttribute("resource");
			String url = context.getStringAttribute("url");
			if (resource != null && url != null) {
				throw new BuilderException(
						"The properties element cannot specify both a URL and a resource based property file reference.  Please specify one or the other.");
			}
			if (resource != null) {
				defaults.putAll(Resources.getResourceAsProperties(resource));
			} else if (url != null) {
				defaults.putAll(Resources.getUrlAsProperties(url));
			}
			Properties vars = configuration.getVariables();
			if (vars != null) {
				defaults.putAll(vars);
			}
			parser.setVariables(defaults);
			configuration.setVariables(defaults);
		}
	}

	private void settingsElement(XNode context) throws Exception {
		if (context != null) {
			Properties props = context.getChildrenAsProperties();
			// Check that all settings are known to the configuration class
			MetaClass metaConfig = MetaClass.forClass(Configuration.class);
			for (Object key : props.keySet()) {
				if (!metaConfig.hasSetter(String.valueOf(key))) {
					throw new BuilderException("The setting " + key
							+ " is not known.  Make sure you spelled it correctly (case sensitive).");
				}
			}
			configuration.setDefaultStatementTimeout(integerValueOf(props.getProperty("defaultStatementTimeout"), null));
		}
	}

	private void mapperElement(XNode parent) throws Exception {
		if (parent != null) {
			for (XNode child : parent.getChildren()) {
				String resource = child.getStringAttribute("resource");
				String url = child.getStringAttribute("url");
				String mapperClass = child.getStringAttribute("class");
				if (resource != null && url == null && mapperClass == null) {
					ErrorContext.instance().resource(resource);
					InputStream inputStream = Resources.getResourceAsStream(resource);
					XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, resource);
					mapperParser.parse();
				} else if (resource == null && url != null && mapperClass == null) {
					ErrorContext.instance().resource(url);
					InputStream inputStream = Resources.getUrlAsStream(url);
					XMLMapperBuilder mapperParser = new XMLMapperBuilder(inputStream, configuration, url);
					mapperParser.parse();
				} else {
					throw new BuilderException("A mapper element may only specify a url, resource or class, but not more than one.");
				}
			}
		}
	}
}