/**
 * Created on 2010-4-27
 * @version v1.0
 *
 */
package cn.blsoft.krport.po;


/**
 * <p>Title:  Page.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class Data {
	
	/**
	 * 标题行模板
	 */
	private String headModel;
	
	/**
	 * 内容行模板
	 */
	private String bodyModel;

	private String footModel;
	
	private String exportModel;

	private KReport kReport;
	
	public Data(KReport kReport){
		this.kReport = kReport;
	}
	
	
	/**
	 * @param headModel
	 * @param bodyModel
	 */
	public Data(KReport kReport, String headModel, String bodyModel) {
		this.headModel = headModel;
		this.bodyModel = bodyModel;
		this.kReport = kReport;
	}

	
	public KReport getKReport(){
		return this.kReport;
	}

	/**
	 * @return the titleModel
	 */
	public String getHeadModel() {
		return headModel;
	}

	/**
	 * @param titleModel the titleModel to set
	 */
	public void setHeadModel(String headModel) {
		this.headModel = headModel;
	}

	/**
	 * @return the bodyModel
	 */
	public String getBodyModel() {
		return bodyModel;
	}

	/**
	 * @param bodyModel the bodyModel to set
	 */
	public void setBodyModel(String bodyModel) {
		this.bodyModel = bodyModel;
	}


	/**
	 * @return the footModel
	 */
	public String getFootModel() {
		return footModel;
	}


	/**
	 * @param footModel the footModel to set
	 */
	public void setFootModel(String footModel) {
		this.footModel = footModel;
	}


	public String getExportModel() {
		return exportModel;
	}


	public void setExportModel(String exportModel) {
		this.exportModel = exportModel;
	}

	
	
}
