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
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import common.Logger;

import cn.blsoft.krport.po.DataSource;
import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.KReportGroup;
import cn.blsoft.krport.po.KReports;
import cn.blsoft.krport.util.Convert;
import cn.blsoft.krport.util.StringUtil;

/**
 * <p>Title:  XmlReader.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class KReportsReader {

	public static Logger log = Logger.getLogger(KReportReader.class);
	
	public static KReports read(File file, ServletContext servletContext) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();                                                      
		DocumentBuilder builder = builderFactory.newDocumentBuilder();               
                                                                        
		Document document = builder.parse(file);  
		                                                                         
		return create(document, servletContext);
	}

	
	public static KReports read(String uri, ServletContext servletContext) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();                                                      
		DocumentBuilder builder = builderFactory.newDocumentBuilder();               
                                                                        
		Document document = builder.parse(uri);  
		                                                                         
		return create(document, servletContext);
	}
	
	
	public static KReports read(InputStream is, ServletContext servletContext) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();                                                      
		DocumentBuilder builder = builderFactory.newDocumentBuilder();               
                                                                        
		Document document = builder.parse(is);  
		                                                                         
		return create(document, servletContext);
	}
	
	/**
	 * Description: 
	 * @param document
	 * @return
	 */
	private static KReports create(Document document, ServletContext servletContext) {
		Element rootElement = document.getDocumentElement();    
		
		KReports kReports = new KReports();
		
		Map<String, DataSource> dataSources = new HashMap<String, DataSource>();
		NodeList dataSourceNodes = ReaderUtil.getNodes(rootElement, "data-sources>data-source");
		for(int i=0;i<dataSourceNodes.getLength();i++){
			DataSource dataSoure = new DataSource();
			Element dataSoureNode = (Element) dataSourceNodes.item(i);
			String name = dataSoureNode.getAttribute("name");
			dataSoure.setDriver(ReaderUtil.getNodeValue(dataSoureNode, "driver"));
			dataSoure.setUrl(ReaderUtil.getNodeValue(dataSoureNode, "url"));
			dataSoure.setUsername(ReaderUtil.getNodeValue(dataSoureNode, "username"));
			dataSoure.setPassword(ReaderUtil.getNodeValue(dataSoureNode, "password"));
			dataSources.put(name, dataSoure);
		}
		kReports.setDataSources(dataSources);
		

		kReports.setPageSize(Convert.stringToInteger(ReaderUtil.getNodeValue(rootElement,"page-size")));
		kReports.setConditionSize(Convert.stringToInteger(ReaderUtil.getNodeValue(rootElement,"condition-size")));
		kReports.setDefaultDataSource(ReaderUtil.getNodeValue(rootElement,"default-data-source"));
		kReports.setSkin(ReaderUtil.getNodeValue(rootElement,"skin"));
		
		if(StringUtil.isBlank(kReports.getSkin())){
			kReports.setSkin("default");
		}
		if(kReports.getPageSize()==null){
			kReports.setPageSize(20);
		}
		if(kReports.getConditionSize()==null){
			kReports.setConditionSize(4);
		}
		
		Map<String, KReportGroup> kReportGroups = new HashMap<String, KReportGroup>();
		NodeList kReportGroupNodes = ReaderUtil.getNodes(rootElement, "kreport-group");
		for(int i=0;i<kReportGroupNodes.getLength();i++){
			Element kReportGroupNode = (Element) kReportGroupNodes.item(i);
			KReportGroup kReportGroup = new KReportGroup();
			kReportGroup.setName(kReportGroupNode.getAttribute("name"));
			kReportGroup.setNamespace(kReportGroupNode.getAttribute("namespace"));
			kReportGroup.setPath(kReportGroupNode.getAttribute("path"));
			kReportGroup.setDisplayName(ReaderUtil.getNodeValue(kReportGroupNode,"display-name"));
			kReportGroup.setPageSize(Convert.stringToInteger(ReaderUtil.getNodeValue(rootElement,"page-size")));
			kReportGroup.setConditionSize(Convert.stringToInteger(ReaderUtil.getNodeValue(rootElement,"condition-size")));
			kReportGroup.setDefaultDataSource(ReaderUtil.getNodeValue(kReportGroupNode,"default-data-source"));
			kReportGroup.setSkin(ReaderUtil.getNodeValue(kReportGroupNode,"skin"));

			if(StringUtil.isBlank(kReportGroup.getDefaultDataSource())){
				kReportGroup.setDefaultDataSource(kReports.getDefaultDataSource());
			}
			if(StringUtil.isBlank(kReportGroup.getSkin())){
				kReportGroup.setSkin(kReports.getSkin());
			}
			if(kReportGroup.getPageSize()==null){
				kReportGroup.setPageSize(kReports.getPageSize());
			}
			if(kReportGroup.getConditionSize()==null){
				kReportGroup.setConditionSize(kReports.getConditionSize());
			}
			Map<String, KReport> kreports = new TreeMap<String, KReport>();
			NodeList kreportsNodes = ReaderUtil.getNodes(kReportGroupNode, "kreport");
			for(int j=0;j<kreportsNodes.getLength();j++){
				Element kreportNode = (Element) kreportsNodes.item(j);
				String reportPath = kreportNode.getTextContent().trim();
				if(null!=reportPath && !reportPath.startsWith("/")){
					reportPath = kReportGroup.getPath()+reportPath;
				}
				KReport kreport = null;
				try {
					kreport = KReportReader.readKReport(servletContext.getRealPath(reportPath));
					if(StringUtil.isBlank(kreport.getDataSource())){
						kreport.setDataSource(kReportGroup.getDefaultDataSource());
					}
					if(StringUtil.isBlank(kreport.getSkin())){
						kreport.setSkin(kReportGroup.getSkin());
					}
					if(kreport.getPageSize()==null){
						kreport.setPageSize(kReportGroup.getPageSize());
					}
					if(kreport.getConditionSize()==null){
						kreport.setConditionSize(kReportGroup.getConditionSize());
					}
					String kreportName=kReportGroup.getNamespace()+kreportNode.getAttribute("name");
					kreports.put(kreportName, kreport);
					log.info("load kReport:\""+kreportName+"\" succeed. file:"+reportPath);
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			kReportGroup.setKreports(kreports);
			kReportGroups.put(kReportGroup.getName(), kReportGroup);
		}
		kReports.setKreportGroups(kReportGroups);		
		
		return kReports;
	}
	


	
	
}
