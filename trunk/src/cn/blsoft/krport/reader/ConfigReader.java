/**
 * Created on 2010-5-1
 * @version v1.0
 *
 */
package cn.blsoft.krport.reader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import cn.blsoft.krport.action.Action;
import cn.blsoft.krport.dialect.Dialect;
import cn.blsoft.krport.htmlwidget.HtmlWidget;
import cn.blsoft.krport.initparam.Initparam;
import cn.blsoft.krport.po.Config;
import cn.blsoft.krport.returntype.ReturnType;

import common.Logger;

/**
 * <p>Title:  XmlReader.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class ConfigReader {

	public static Logger log = Logger.getLogger(ConfigReader.class);
	
	public static Config read(File file) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();                                                      
		DocumentBuilder builder = builderFactory.newDocumentBuilder();               
                                                                        
		Document document = builder.parse(file);  
		                                                                         
		return create(document);
	}

	
	public static Config read(String uri) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();                                                      
		DocumentBuilder builder = builderFactory.newDocumentBuilder();               
                                                                        
		Document document = builder.parse(uri);  
		                                                                         
		return create(document);
	}
	
	
	public static Config read(InputStream is) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();                                                      
		DocumentBuilder builder = builderFactory.newDocumentBuilder();               
                                                                        
		Document document = builder.parse(is);  
		                                                                         
		return create(document);
	}
	
	/**
	 * Description: 
	 * @param document
	 * @return
	 */
	private static Config create(Document document) {
		Config config = new Config();		
		Element rootElement = document.getDocumentElement();  
		
		Map<String, Action> actions = new HashMap<String, Action>();
		NodeList actionNodes = ReaderUtil.getNodes(rootElement, "actions>action");
		if(actionNodes!=null){
			for(int i=0;i<actionNodes.getLength();i++){
				Element widgetNode = (Element) actionNodes.item(i);
				String name = widgetNode.getAttribute("name");
				String className = widgetNode.getTextContent().trim();
				try {
					actions.put(name, (Action) Class.forName(className).newInstance());
					log.info("load Action:\""+name+"\" succeed. class:"+className);
				} catch (Exception e) {
					log.error("load Action:\""+name+"\" fail. class:"+className);
				}
			}
		}
		config.setActions(actions);
		
		Map<String, HtmlWidget> htmlWidgets = new HashMap<String, HtmlWidget>();
		NodeList htmlwidgetNodes = ReaderUtil.getNodes(rootElement, "htmlwidgets>htmlwidget");
		if(htmlwidgetNodes!=null){
			for(int i=0;i<htmlwidgetNodes.getLength();i++){
				Element widgetNode = (Element) htmlwidgetNodes.item(i);
				String name = widgetNode.getAttribute("name");
				String className = widgetNode.getTextContent().trim();
				try {
					htmlWidgets.put(name, (HtmlWidget) Class.forName(className).newInstance());
					log.info("load HtmlWidget:\""+name+"\" succeed. class:"+className);
				} catch (Exception e) {
					log.error("load HtmlWidget:\""+name+"\" fail. class:"+className);
				}
			}
		}
		config.setHtmlWidgets(htmlWidgets);
		
		Map<String, ReturnType> returnTypes = new HashMap<String, ReturnType>();
		NodeList returntypeNodes = ReaderUtil.getNodes(rootElement, "returntypes>returntype");
		if(returntypeNodes!=null){
			for(int i=0;i<returntypeNodes.getLength();i++){
				Element returntypeNode = (Element) returntypeNodes.item(i);
				String name = returntypeNode.getAttribute("name");
				String className = returntypeNode.getTextContent().trim();
				try {
					returnTypes.put(name, (ReturnType) Class.forName(className).newInstance());
					log.info("load ReturnType:\""+name+"\" succeed. class:"+className);
				} catch (Exception e) {
					log.error("load ReturnType:\""+name+"\" fail. class:"+className);
				}
			}	
		}
		config.setReturnTypes(returnTypes);
		
		
		Map<String, Dialect> dialects = new HashMap<String, Dialect>();
		NodeList dialectNodes = ReaderUtil.getNodes(rootElement, "dialects>dialect");
		if(dialectNodes!=null){
			for(int i=0;i<dialectNodes.getLength();i++){
				Element dialectNode = (Element) dialectNodes.item(i);
				String driver = dialectNode.getAttribute("driver");
				String className = dialectNode.getTextContent().trim();
				try {
					dialects.put(driver, (Dialect) Class.forName(className).newInstance());
					log.info("load dialect:\""+driver+"\" succeed. class:"+className);
				} catch (Exception e) {
					log.error("load dialect:\""+driver+"\" fail. class:"+className);
				}
			}	
		}
		config.setDialects(dialects);
		
		Map<String, Initparam> initparams = new HashMap<String, Initparam>();
		NodeList initparamNodes = ReaderUtil.getNodes(rootElement, "initparams>initparam");
		if(initparamNodes!=null){
			for(int i=0;i<initparamNodes.getLength();i++){
				Element initparamNode = (Element) initparamNodes.item(i);
				String name = initparamNode.getAttribute("name");
				String className = initparamNode.getTextContent().trim();
				try {
					initparams.put(name, (Initparam) Class.forName(className).newInstance());
					log.info("load initparam:\""+name+"\" succeed. class:"+className);
				} catch (Exception e) {
					log.error("load initparam:\""+name+"\" fail. class:"+className);
				}
			}	
		}
		config.setInitparams(initparams);
		
		return config;

	}
	


	
	
}
