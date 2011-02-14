/**
 * Created on 2010-6-6
 * @version v1.0
 *
 */
package cn.blsoft.krport.synthesizer;

import java.util.Map;

import cn.blsoft.krport.po.KReport;

/**
 * <p>Title:  KReportPage.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class KReportSynthesizer implements Synthesizer{

	private KReport kReport;
	
	public KReportSynthesizer(){}
	
	public KReportSynthesizer(KReport kReport){
		this.kReport = kReport;
	}
	
	public String getHtml(Map<String, Object> param){
		StringBuffer htmlBuffer = new StringBuffer();
		htmlBuffer.append("\n<html>");
		htmlBuffer.append(new HeadSynthesizer(kReport).getHtml(param));
		htmlBuffer.append("\n<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>");

		htmlBuffer.append(new PageActionSynthesizer(kReport).getHtml(param));
		
		htmlBuffer.append(new ConditionSynthesizer(kReport).getHtml(param));
		
		htmlBuffer.append("\n<iframe id='_viewer' name='_viewer' frameborder='no' scrolling = 'auto' width='100%' ></iframe>");
		htmlBuffer.append("\n</body>");
		htmlBuffer.append("\n</html>");
		return htmlBuffer.toString();
	}

	/**
	 * @return the kReport
	 */
	public KReport getkReport() {
		return kReport;
	}

	/**
	 * @param kReport the kReport to set
	 */
	public void setkReport(KReport kReport) {
		this.kReport = kReport;
	}

}
