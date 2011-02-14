/**
 * Created on 2010-6-7
 * @version v1.0
 *
 */
package cn.blsoft.krport.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.PageData;
import cn.blsoft.krport.query.SqlQuery;
import cn.blsoft.krport.util.ServletUtil;
import cn.blsoft.krport.util.StringUtil;

/**
 * <p>Title:  ExportAction.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class Export2Action implements Action {

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.action.Action#execute(java.lang.String, java.util.Map, javax.servlet.http.HttpServletResponse)
	 */
	public void execute(HttpServletRequest request,	HttpServletResponse response) throws IOException {
		String kReportName = ServletUtil.getKReportName(request);
		KReport kReport = KReportContext.kReports.getKRport(kReportName);
		Map<String,Object> param = ServletUtil.initParam(request);
		response.setContentType("application/x-msdownload;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String fileName = StringUtil.toStandardStr(kReport.getDisplayName());
		response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xls");
		PageData pageData = SqlQuery.Query(kReport,param,KReportContext.exportMaxRows);
		ServletOutputStream out = response.getOutputStream();
		WritableWorkbook workbook = Workbook.createWorkbook(out);
		
		try{			
			WritableFont font = new WritableFont(WritableFont.TIMES, 12);
			WritableCellFormat areaTitleFormat = new WritableCellFormat(font);
			areaTitleFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			areaTitleFormat.setBackground(Colour.RED);
			areaTitleFormat.setWrap(false);                                     //ÊÇ·ñ»»ÐÐ(·ñ)
			
			WritableFont rowFont = new WritableFont(WritableFont.TIMES, 11);
			WritableCellFormat rowFormat = new WritableCellFormat(rowFont);
			rowFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			rowFormat.setBackground(Colour.SKY_BLUE);
			rowFormat.setWrap(false); 
						
			String name="Ä£°å";
			List<String[]> bodys=pageData.getBodys();
			int bodysSize = bodys.size();
			if(bodysSize>0){
				String[] temp = bodys.get(0);
				if(temp.length>7){
					name=temp[1];
				}
			}
			
			
			WritableSheet sheet0 = workbook.createSheet(name, 0);
			
			sheet0.addCell(new Label(0, 0, bodysSize+""));	
				int index=0;
				for(String[] obj:pageData.getBodys()){
					sheet0.setColumnView(index, 40);
					sheet0.addCell(new Label(index, 2, obj[2], areaTitleFormat));	
					sheet0.addCell(new Label(index, 3, obj[3], rowFormat));	
					sheet0.addCell(new Label(index, 4, obj[4], rowFormat));	
					sheet0.addCell(new Label(index, 5, obj[5], rowFormat));	
					sheet0.addCell(new Label(index, 6, obj[6], rowFormat));	
					sheet0.addCell(new Label(index, 7, obj[7], rowFormat));	
					index++;
				}
				
			workbook.write();
			workbook.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		out.close();

	}
	


}
