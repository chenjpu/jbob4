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

import common.Logger;

import cn.blsoft.krport.po.Condition;
import cn.blsoft.krport.po.Cross;
import cn.blsoft.krport.po.Data;
import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.PageAction;
import cn.blsoft.krport.util.Convert;

/**
 * <p>Title:  XmlReader.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class KReportReader {
	
	public static Logger log = Logger.getLogger(KReportReader.class);

	public static KReport readKReport(File file) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();                                                      
		DocumentBuilder builder = builderFactory.newDocumentBuilder();               
                                                                        
		Document document = builder.parse(file);  
		                                                                         
		return create(document);
	}

	
	public static KReport readKReport(String uri) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();                                                      
		DocumentBuilder builder = builderFactory.newDocumentBuilder();               
                                                                        
		Document document = builder.parse(uri);  
		                                                                         
		return create(document);
	}
	
	
	public static KReport readKReport(InputStream is) throws ParserConfigurationException, SAXException, IOException{
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
	private static KReport create(Document document) {
		Element rootElement = document.getDocumentElement();    
		
		KReport kReport = new KReport();
		
		kReport.setName(ReaderUtil.getNodeValue(rootElement,"name"));
		kReport.setDisplayName(ReaderUtil.getNodeValue(rootElement,"display-name"));
		kReport.setComment(ReaderUtil.getNodeValue(rootElement,"comment"));
		kReport.setPageable(Convert.stringToBoolean(ReaderUtil.getNodeValue(rootElement,"pageable")));
		kReport.setPageSize(Convert.stringToInteger(ReaderUtil.getNodeValue(rootElement,"page-size")));
		kReport.setConditionSize(Convert.stringToInteger(ReaderUtil.getNodeValue(rootElement,"condition-size")));
		kReport.setSkin(ReaderUtil.getNodeValue(rootElement,"skin"));
		kReport.setkSql(ReaderUtil.getNodeValue(rootElement,"ksql"));
		kReport.setDataSource(ReaderUtil.getNodeValue(rootElement,"data-source"));
		kReport.setScripts(ReaderUtil.getNodeValues(rootElement, "script"));
		
		Data data =  new Data(kReport);
		data.setHeadModel(ReaderUtil.getNodeValue(rootElement,"data>thead"));
		data.setBodyModel(ReaderUtil.getNodeValue(rootElement,"data>tbody"));
		data.setFootModel(ReaderUtil.getNodeValue(rootElement,"data>tfoot"));
		data.setExportModel(ReaderUtil.getNodeValue(rootElement,"data>export"));
		kReport.setData(data);
		
		Cross cross = new Cross();
		cross.setCrossText(ReaderUtil.getNodeValue(rootElement,"cross>cross-text"));
		cross.setColField(ReaderUtil.getNodeValue(rootElement,"cross>col-field"));
		cross.setRowField(ReaderUtil.getNodeValue(rootElement,"cross>row-field"));
		cross.setValueField(ReaderUtil.getNodeValue(rootElement,"cross>value-field"));
		cross.setColCount(Convert.stringToBoolean(ReaderUtil.getNodeValue(rootElement,"cross>col-count")));
		cross.setRowCount(Convert.stringToBoolean(ReaderUtil.getNodeValue(rootElement,"cross>row-count")));
		kReport.setCross(cross);
		
		Map<String, PageAction> actions = new HashMap<String, PageAction>();
		NodeList actionNodes = ReaderUtil.getNodes(rootElement, "actions>action");
		if(actionNodes!=null){
			for(int i=0;i<actionNodes.getLength();i++){
				Element actionNode = (Element) actionNodes.item(i);
				PageAction action = new PageAction(kReport);
				action.setName(actionNode.getAttribute("name"));
				action.setIndex(Convert.stringToInt(ReaderUtil.getNodeValue(actionNode,"index")));
				action.setDisplayName(ReaderUtil.getNodeValue(actionNode,"display-name"));
				action.setAction(ReaderUtil.getNodeValue(actionNode,"do"));
				action.setScripts(ReaderUtil.getNodeValues(actionNode, "script"));
				actions.put(action.getName(), action);
			}
		}
		kReport.setActions(actions);
		
		Map<String, Condition> conditions = new HashMap<String, Condition>();
		NodeList conditionNodes = ReaderUtil.getNodes(rootElement, "conditions>condition");
		if(conditionNodes!=null){
			for(int i=0;i<conditionNodes.getLength();i++){
				Element conditionNode = (Element) conditionNodes.item(i);
				Condition condition = new Condition(kReport);
				condition.setName(conditionNode.getAttribute("name"));
				condition.setIndex(Convert.stringToInt(ReaderUtil.getNodeValue(conditionNode,"index")));
				condition.setDisplayName(ReaderUtil.getNodeValue(conditionNode,"display-name"));
				condition.setType(ReaderUtil.getNodeValue(conditionNode,"type"));
				condition.setDefaultValue(ReaderUtil.getNodeValue(conditionNode,"default-value"));
				condition.setExtend(ReaderUtil.getNodeValue(conditionNode,"extend"));
				condition.setReturnType(ReaderUtil.getNodeValue(conditionNode,"return-type"));
				condition.setValid(ReaderUtil.getNodeValue(conditionNode,"valid"));
				condition.setRequired(Convert.stringToBoolean(ReaderUtil.getNodeValue(conditionNode,"required")));
				conditions.put(condition.getName(), condition);
			}
		}
		kReport.setConditions(conditions);
		return kReport;
	}
	
	
}
