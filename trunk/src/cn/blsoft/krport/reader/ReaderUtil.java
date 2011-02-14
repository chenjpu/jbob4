/**
 * Created on 2010-4-29
 * @version v1.0
 *
 */
package cn.blsoft.krport.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * <p>Title:  BaseReader.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class ReaderUtil {
	
	public static String getNodeValue(Element element, String tag){
		String[] tags = tag.split(">");
		NodeList nodelist = element.getElementsByTagName(tags[0].trim());
		if(null!=nodelist && nodelist.getLength()>0){
			if(tags.length==1){
				return nodelist.item(0).getTextContent();
			}else{
				return getNodeValue((Element) nodelist.item(0),tag.substring(tag.indexOf(">")+1));
			}
		}else{
			return null;
		}
	}
	
	public static List<String> getNodeValues(Element element, String tag){
		List<String> values = new ArrayList<String>();
		NodeList nodeList = getNodes(element, tag);
		if (nodeList!=null){
			for(int i=0; i<nodeList.getLength(); i++){
				values.add(nodeList.item(i).getTextContent());
			}
		}
		return values;
	}
	
	public static NodeList getNodes(Element element, String tag){
		String[] tags = tag.split(">");
		NodeList nodelist = element.getElementsByTagName(tags[0].trim());
		if(null!=nodelist && nodelist.getLength()>0){
			if(tags.length==1){
				return nodelist;
			}else{
				return getNodes((Element) nodelist.item(0),tag.substring(tag.indexOf(">")+1));
			}
		}else{
			return null;
		}
	}
	
	public static String readFile(final String filePath){
		try{
			File file = new File(filePath);
			FileInputStream input = new FileInputStream(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(input));
			StringBuffer sqlBuffer = new StringBuffer();
			String sqlString = in.readLine();
			while(sqlString!=null){
				sqlBuffer.append(sqlString).append("\n");
				sqlString = in.readLine();
			}
			if(null!=in){try{in.close();}catch(Exception e){}}
			if(null!=input){try{input.close();}catch(Exception e){}}
			return sqlBuffer.toString();
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}		
	}
	
}
