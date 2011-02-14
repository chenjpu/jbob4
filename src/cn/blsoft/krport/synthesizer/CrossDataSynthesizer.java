/**
 * Created on 2010-4-27
 * @version v1.0
 *
 */
package cn.blsoft.krport.synthesizer;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.CrossData;
import cn.blsoft.krport.po.CrossKey;
import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.PageData;
import cn.blsoft.krport.util.StringUtil;
/**
 * <p>Title:  Page.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class CrossDataSynthesizer  implements Synthesizer{	

	private KReport kReport;
	
	private PageData pageData;
	
	List<KeyField> rowGroup = new ArrayList<KeyField>();
		
	List<KeyField> colGroup = new ArrayList<KeyField>();
	
	String[] valueGroup;
	
	Map<String,String> valueOpenKReport = new HashMap<String,String>();
	
	private CrossData crossData;


	public CrossDataSynthesizer(KReport kReport){
		this.kReport = kReport;
	}

	public CrossDataSynthesizer(KReport kReport, PageData pageData){
		this.kReport = kReport;
		this.pageData=pageData;
		
		String[] colGroupStrings=kReport.getCross().getColField().replace(" ", "").split(",");
		for(String colGroupString:colGroupStrings){
			String[] fieldGroup = colGroupString.split(":");
			if(fieldGroup.length>1){
				colGroup.add(new KeyField(fieldGroup[1].trim(),fieldGroup[0].trim()));
			}else{
				colGroup.add(new KeyField(fieldGroup[0].trim(),fieldGroup[0].trim()));
			}
		}
		
		String[] rowGroupStrings=kReport.getCross().getRowField().replace(" ", "").split(",");
		for(String rowGroupString:rowGroupStrings){
			String[] fieldGroup = rowGroupString.split(":");
			if(fieldGroup.length>1){
				rowGroup.add(new KeyField(fieldGroup[1],fieldGroup[0]));
			}else{
				rowGroup.add(new KeyField(fieldGroup[0],fieldGroup[0]));
			}
		}		
		
		String[] valueGroupStrings = kReport.getCross().getValueField().replace(" ", "").split(",");
		valueGroup = new String[valueGroupStrings.length];
		for(int i=0;i<valueGroupStrings.length;i++){
			String[] fieldGroup = valueGroupStrings[i].split(":");
			valueGroup[i]=fieldGroup[0];
			if(fieldGroup.length>1){
				valueOpenKReport.put(fieldGroup[0], fieldGroup[1]);
			}
		}
		
		crossData = this.getCrossData(colGroup, rowGroup, valueGroup);
	}

	/**
	 * Description: 构造列标题HTML列表
	 * @param lineBeffer HTML列表
	 * @param i 层次
	 * @param crossKey 交叉Key
	 */
	 void colCrossKeyToHtml(List<StringBuffer> lineBeffer,int i,CrossKey crossKey){
		if(crossKey.getChilds().size()==0){
			for(String valueName:valueGroup){
				if(lineBeffer.size()-i>1){
					lineBeffer.get(i).append("<th>").append(valueName).append("</th>");
				}
				if(valueOpenKReport.containsKey(valueName)){
					lineBeffer.get(lineBeffer.size()-1).append("<td><a href=\"javascript:openList('")
					.append(valueOpenKReport.get(valueName)).append("','")
					.append(crossKey.getValue(valueName)).append("','").append(crossKey.getQueryString()+"&_valueField="+valueName)
					.append("')\">").append(crossKey.getValue(valueName)).append("</a></td>");
				}else{
					lineBeffer.get(lineBeffer.size()-1).append("<td>").append(crossKey.getValue(valueName)).append("</td>");
				}
				
			}			
		}else{
			List<CrossKey> childs = crossKey.getChilds();
			Collections.sort(childs);
			for(CrossKey child:childs){
				lineBeffer.get(i).append("<th colspan=").append(child.getSize()*valueGroup.length).append(">").append(child.getKey()).append("</th>");
				colCrossKeyToHtml(lineBeffer,i+1,child);
			}
		}
	}

		
	/**
	 * Description: 构造行标题HTML列表
	 * @param lineBeffer HTML列表
	 * @param i 行数
	 * @param crossRowKey 行Key
	 * @param crossCellKey 单元Key
	 */
	private void rowCrossKeyToHtml(List<StringBuffer> lineBeffer,int i,CrossKey crossRowKey, CrossKey crossCellKey){
		if(crossRowKey.getChilds().size()!=0){
			List<CrossKey> childs = crossRowKey.getChilds();
			List<CrossKey> cellchilds = crossCellKey.getChilds();
			Collections.sort(childs);
			for(CrossKey child:childs){
				CrossKey cellchild = crossCellKey.getChild(child.getKey());
				lineBeffer.get(i).append("<th rowspan=").append(child.getSize()).append(">").append(child.getKey()).append("</th>");
				if(child.getChilds().size()==0){
					lineBeffer.get(i).append(createValueHtml(crossData.getTopColKey(),cellchild));
					if(this.kReport.getCross().getRowCount()){
						for(String valueName:valueGroup){						
							if(valueOpenKReport.containsKey(valueName)){
								lineBeffer.get(i).append("<td><a href=\"javascript:openList('")
								.append(valueOpenKReport.get(valueName)).append("','")
								.append(child.getValue(valueName)).append("','").append(child.getQueryString()+"&_valueField="+valueName)
								.append("')\">").append(child.getValue(valueName)).append("</a></td>");
							}else{
								lineBeffer.get(i).append("<td>").append(child.getValue(valueName)).append("</td>");
							}
						}
					}
				}
				rowCrossKeyToHtml(lineBeffer,i,child,cellchild);
				i=i+child.getSize();
			}
		}
	}
		
	/**
	 * Description: 构造交叉Keyt
	 * @param type	排序项类型
	 * @param sortValue 排序值
	 * @param keyValue key值
	 * @return
	 */
	private CrossKey createCrossKey(int type, String sortValue,String fieldName, String keyValue){
		switch (type) {
		case Types.INTEGER:
			if(StringUtil.isBlank(sortValue)){
				return new CrossKey<Integer>(fieldName,Integer.MAX_VALUE,keyValue);
			}else{
				return new CrossKey<Integer>(fieldName,new Integer(sortValue),keyValue);
			}
		case Types.BIT:
		case Types.TINYINT:
		case Types.SMALLINT:
			if(StringUtil.isBlank(sortValue)){
				return new CrossKey<Short>(fieldName,Short.MAX_VALUE,keyValue);
			}else{
				return new CrossKey<Short>(fieldName,new Short(sortValue),keyValue);
			}
		case Types.BIGINT:
			if(StringUtil.isBlank(sortValue)){
				return new CrossKey<Long>(fieldName,Long.MAX_VALUE,keyValue);
			}else{
				return new CrossKey<Long>(fieldName,new Long(sortValue),keyValue);
			}
		case Types.DECIMAL:
		case Types.NUMERIC:
			if(StringUtil.isBlank(sortValue)){
				return new CrossKey<BigDecimal>(fieldName,new BigDecimal(Double.MAX_VALUE),keyValue);
			}else{
				return new CrossKey<BigDecimal>(fieldName,new BigDecimal(sortValue),keyValue);
			}
		case Types.REAL:
			if(StringUtil.isBlank(sortValue)){
				return new CrossKey<Float>(fieldName,Float.MAX_VALUE,keyValue);
			}else{
				return new CrossKey<Float>(fieldName,new Float(sortValue),keyValue);
			}
		case Types.FLOAT:
		case Types.DOUBLE:
			if(StringUtil.isBlank(sortValue)){
				return new CrossKey<Double>(fieldName,Double.MAX_VALUE,keyValue);
			}else{
				return new CrossKey<Double>(fieldName,new Double(sortValue),keyValue);
			}
		default:
			return new CrossKey<String>(fieldName,sortValue,keyValue);
		}
	}

	/**
	 * Description: 构造值HTML
	 * @param colCrossKey 列值
	 * @param crossKey 单元值
	 * @return
	 */
	private StringBuffer createValueHtml(CrossKey colCrossKey,CrossKey crossKey){
		StringBuffer htmlBuffer = new StringBuffer();
		if(colCrossKey.getChilds().size()==0){
			for(String valueName:valueGroup){
				if(valueOpenKReport.containsKey(valueName)){
					htmlBuffer.append("<td><a href=\"javascript:openList('")
					.append(valueOpenKReport.get(valueName)).append("','")
					.append(crossKey.getValue(valueName)).append("','").append(crossKey.getQueryString()+"&_valueField="+valueName)
					.append("')\">").append(crossKey.getValue(valueName)).append("</a></td>");
				}else{
					htmlBuffer.append("<td>").append(crossKey.getValue(valueName)).append("</td>");
				}
			}
		}else{
			List<CrossKey> childs = colCrossKey.getChilds();
			List<CrossKey> cellchilds = crossKey.getChilds();
			Collections.sort(childs);
			for(CrossKey child:childs){
				CrossKey ck = crossKey.getChild(child.getKey());
				if(ck==null){
					for(int i=0;i<child.getSize();i++){
						for(String valueName:valueGroup){
							if(valueOpenKReport.containsKey(valueName)){
								htmlBuffer.append("<td><a href=\"javascript:openList('")
								.append(valueOpenKReport.get(valueName)).append("','0','')\">0</a></td>");
							}else{
								htmlBuffer.append("<td>0</td>");
							}
						}
					}
				}else{
					htmlBuffer.append(createValueHtml(child,ck));
				}
			}
		}
		return htmlBuffer;
	}

	/**
	 * Description: 获取CrossData对像
	 * @param colGroup 列字段列表
	 * @param rowGroup 行字段列表
	 * @param valueNames 值字段数组
	 * @return
	 */
	private CrossData getCrossData(List<KeyField> colGroup,List<KeyField> rowGroup,String[] valueNames ){
		CrossData crossData = new CrossData();	
		crossData.getTopColKey().setChilds(new ArrayList<CrossKey>());
		crossData.getTopRowKey().setChilds(new ArrayList<CrossKey>());
		crossData.getTopCellKey().setChilds(new ArrayList<CrossKey>());
		

		Map<String,Integer> nameMap = new HashMap<String,Integer>();		
		for(KeyField keyField:colGroup){
			for(int i=1;i<pageData.getHead().length;i++){
				if(keyField.getKeyName().equals(pageData.getHead()[i])) nameMap.put(keyField.getKeyName(), i);
				if(keyField.getKeySortName().equals(pageData.getHead()[i])) nameMap.put(keyField.getKeySortName(), i);
			}
		}
		for(KeyField keyField:rowGroup){
			for(int i=1;i<pageData.getHead().length;i++){
				if(keyField.getKeyName().equals(pageData.getHead()[i])) nameMap.put(keyField.getKeyName(), i);
				if(keyField.getKeySortName().equals(pageData.getHead()[i])) nameMap.put(keyField.getKeySortName(), i);
			}
		}
		for(String name:valueNames){
			for(int i=1;i<pageData.getHead().length;i++){
				if(name.equals(pageData.getHead()[i])) nameMap.put(name, i);
			}
		}
		
		
		for(String[] body:pageData.getBodys()){
			//取值
			Map<String,Double> values = new HashMap<String,Double>();
			for(String valueName:valueNames){
				try{
					values.put(valueName, new Double(body[nameMap.get(valueName)]));
				}catch(Exception e){
					values.put(valueName, 0.0);
				}
			}
			
			//设置topColKey
			List<CrossKey> groupKeyList = new ArrayList<CrossKey>();
			for(KeyField keyField:colGroup){
				int type = pageData.getHeadType()[nameMap.get(keyField.keySortName)];
				groupKeyList.add(createCrossKey(type,body[nameMap.get(keyField.keySortName)],keyField.getKeyName(),body[nameMap.get(keyField.getKeyName())]));
			}
			groupKeyList.get(groupKeyList.size()-1).setValues(values);
			for(int i=groupKeyList.size()-2;i>=0;i--){
				groupKeyList.get(i+1).setParent(groupKeyList.get(i));
				groupKeyList.get(i).addChildCrossKey(groupKeyList.get(i+1));
			}
			crossData.getTopColKey().addChildCrossKey(groupKeyList.get(0).clone());
			
			//设置topRKey
			groupKeyList = new ArrayList<CrossKey>();
			for(KeyField keyField:rowGroup){
				int type = pageData.getHeadType()[nameMap.get(keyField.keySortName)];
				groupKeyList.add(createCrossKey(type,body[nameMap.get(keyField.keySortName)],keyField.getKeyName(),body[nameMap.get(keyField.getKeyName())]));
			}
			groupKeyList.get(groupKeyList.size()-1).setValues(values);
			for(int i=groupKeyList.size()-2;i>=0;i--){
				groupKeyList.get(i+1).setParent(groupKeyList.get(i));
				groupKeyList.get(i).addChildCrossKey(groupKeyList.get(i+1));
			}
			crossData.getTopRowKey().addChildCrossKey(groupKeyList.get(0).clone());
			
			//设置topCellKey
			groupKeyList = new ArrayList<CrossKey>();
			List<KeyField> cellGroup = new ArrayList<KeyField>();
			cellGroup.addAll(rowGroup);
			cellGroup.addAll(colGroup);
			for(KeyField keyField:cellGroup){
				int type = pageData.getHeadType()[nameMap.get(keyField.keySortName)];
				groupKeyList.add(createCrossKey(type,body[nameMap.get(keyField.keySortName)],keyField.getKeyName(),body[nameMap.get(keyField.getKeyName())]));
			}
			groupKeyList.get(groupKeyList.size()-1).setValues(values);
			for(int i=groupKeyList.size()-2;i>=0;i--){
				groupKeyList.get(i+1).setParent(groupKeyList.get(i));
				groupKeyList.get(i).addChildCrossKey(groupKeyList.get(i+1));
			}
			crossData.getTopCellKey().addChildCrossKey(groupKeyList.get(0).clone());			
		}
		return crossData;
	}
	
	/**
	 * Description: 生成交叉报表Table数据
	 * @return
	 */
	private String getDataHtml(){
		StringBuffer htmlBuffer = new StringBuffer();
		int colTHsize = rowGroup.size();
		int rowTHsize = colGroup.size();
		boolean isShowValueNames = valueGroup.length>1;
		int rowRealTHsize=rowTHsize+1+(isShowValueNames?1:0);
		
		List<StringBuffer> rowLineBeffers = new ArrayList<StringBuffer>();
		for(int i=0;i<rowRealTHsize;i++){
			rowLineBeffers.add(new StringBuffer());
		}	

		rowLineBeffers.get(0).append("<th rowspan=").append(rowTHsize+(isShowValueNames?1:0))
			.append(" colspan=").append(colTHsize).append(">")
			.append(StringUtil.objectToString(kReport.getCross().getCrossText())).append("</th>");
		
		rowLineBeffers.get(rowLineBeffers.size()-1).append("<th colspan=").append(colTHsize).append(" >")
			.append("总计").append("</th>");
		
		
		colCrossKeyToHtml(rowLineBeffers,0,crossData.getTopColKey());
		if(this.kReport.getCross().getRowCount()){
			rowLineBeffers.get(0).append("<th rowspan=").append(rowTHsize)
				.append(" colspan=").append(valueGroup.length).append(">")
				.append("总计").append("</th>");
		}
		
		if(isShowValueNames){
			for(String valueName:valueGroup){
				rowLineBeffers.get(rowTHsize).append("<th>").append(valueName).append("</th>");
			}
		}
		
		for(String valueName:valueGroup){
			if(valueOpenKReport.containsKey(valueName)){
				rowLineBeffers.get(rowLineBeffers.size()-1).append("<td><a href=\"javascript:openList('")
				.append(valueOpenKReport.get(valueName)).append("','").append(crossData.getTopColKey().getValue(valueName)).append("','_valueField=").append(valueName).append("')\">").append(crossData.getTopColKey().getValue(valueName)).append("</a></td>");
			}else{
				rowLineBeffers.get(rowLineBeffers.size()-1).append("<td>").append(crossData.getTopColKey().getValue(valueName)).append("</td>");
			}
		}
		
		
		List<StringBuffer> datarowLineBeffers = new ArrayList<StringBuffer>();
		for(int i=0;i<crossData.getTopRowKey().getSize();i++){
			datarowLineBeffers.add(new StringBuffer());
		}
		
		
		rowCrossKeyToHtml(datarowLineBeffers,0,crossData.getTopRowKey(),crossData.getTopCellKey());
		
		
		for(int i=0;i<rowLineBeffers.size()-1;i++){
			StringBuffer brffer=rowLineBeffers.get(i);
			htmlBuffer.append("\n\t<tr>").append(brffer).append("</tr>");
		}
		for(StringBuffer brffer:datarowLineBeffers){
			htmlBuffer.append("\n\t<tr>").append(brffer).append("</tr>");
		}
		if(this.kReport.getCross().getColCount()&&this.kReport.getCross().getRowCount()){
			htmlBuffer.append("\n\t<tr>").append(rowLineBeffers.get(rowLineBeffers.size()-1)).append("</tr>");
		}
		return htmlBuffer.toString();
	}
	
	/* (non-Javadoc)
	 * @see cn.blsoft.krport.synthesizer.Synthesizer#getHtml()
	 */
	public String getHtml(Map<String, Object> param){
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("\n<head>");
		htmlBuffer.append("\n\t<title>").append(kReport.getDisplayName()).append("</title>");
		htmlBuffer.append("\n\t<link type='text/css' rel='stylesheet' href='").append(KReportContext.BASE).append("/kReport/css/").append(kReport.getSkin()).append("/kReport.css' />");
		htmlBuffer.append("\n\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/kReport/js/action.js'></script>");	
		htmlBuffer.append("\n\t<script type='text/javascript' src='").append(KReportContext.BASE).append("/kReport/js/data.js'></script>");	
		htmlBuffer.append("\n</head>");
		htmlBuffer.append("\n<body leftmargin='0' topmargin='1' marginwidth='0' marginheight='0'  style='overflow: auto'>");	
		htmlBuffer.append("<table  width='100%' cellspacing='1'  class='kReportCrossTable'>");
		if(pageData.getBodys().size()==0){
			htmlBuffer.append("<tr><th>没有记录</th></tr>");
		}else{
			htmlBuffer.append(getDataHtml());
		}
		htmlBuffer.append("\n</table>");
		htmlBuffer.append("\n<div style='font-size:9pt;color=#999999'><pre>").append(StringUtil.objectToString(kReport.getComment())).append("</pre><div>");
		htmlBuffer.append("\n</body>");
		return htmlBuffer.toString();		
	}
	
	/**
	 * @return the kReport
	 */
	public KReport getkReport() {
		return kReport;
	}
	
	/**
	 * @return the pageData
	 */
	public PageData getPageData() {
		return pageData;
	}
	

	/**
	 * @param kReport the kReport to set
	 */
	public void setkReport(KReport kReport) {
		this.kReport = kReport;
	}
	
	/**
	 * @param pageData the pageData to set
	 */
	public void setPageData(PageData pageData) {
		this.pageData = pageData;
	}
	
	public class KeyField{
		private String keyName;
		private String keySortName;
		public KeyField(String keyName,String keySortName){
			this.keyName=keyName;
			this.keySortName=keySortName;
		}
		public String getKeyName() {
			return keyName;
		}
		public String getKeySortName() {
			return keySortName;
		}
		public void setKeyName(String keyName) {
			this.keyName = keyName;
		}
		public void setKeySortName(String keySortName) {
			this.keySortName = keySortName;
		}
		
	}
}
