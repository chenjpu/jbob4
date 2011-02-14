/**
 * Created on 2010-6-7
 * @version v1.0
 *
 */
package cn.blsoft.krport.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import cn.blsoft.krport.engine.KReportContext;
import cn.blsoft.krport.po.KReport;
import cn.blsoft.krport.po.PageData;
import cn.blsoft.krport.query.SqlQuery;
import cn.blsoft.krport.util.ExcelUtil;
import cn.blsoft.krport.util.ServletUtil;
import cn.blsoft.krport.util.StringUtil;

/**
 * <p>Title:  ExportAction.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class ExportOthersAction implements Action {

	/* (non-Javadoc)
	 * @see cn.blsoft.krport.action.Action#execute(java.lang.String, java.util.Map, javax.servlet.http.HttpServletResponse)
	 */
	public void execute(HttpServletRequest request,	HttpServletResponse response) throws IOException {
		String kReportName = ServletUtil.getKReportName(request);
		KReport kReport = KReportContext.kReports.getKRport(kReportName);
		Map<String,Object> param = ServletUtil.initParam(request);
		response.setContentType("application/x-msdownload;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String fileName = StringUtil.toStandardStr(kReport.getDisplayName()+"清单");
		response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xls");
		ServletOutputStream out = response.getOutputStream();
		WritableWorkbook workbook = Workbook.createWorkbook(out);
		
		try{
			WritableFont font = new WritableFont(WritableFont.TIMES, 10,WritableFont.BOLD);
			WritableCellFormat areaTitleFormat = new WritableCellFormat(font);
			areaTitleFormat.setAlignment(Alignment.CENTRE);                     //居中对齐
			areaTitleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);     //垂直对齐
			areaTitleFormat.setWrap(false);                                     //是否换行(否)
			
			WritableFont rowFont = new WritableFont(WritableFont.TIMES, 10);
			WritableCellFormat rowFormat = new WritableCellFormat(rowFont);
			rowFormat.setAlignment(Alignment.LEFT);                     //左对齐
			rowFormat.setVerticalAlignment(VerticalAlignment.CENTRE);     //垂直对齐
			rowFormat.setWrap(false); 
	
			String kreportString = (String) param.get("_parameter");
			String[] kreports = kreportString.split(",");
			
			int sheetIndex=0;
			for(String kreportName:kreports){
				kReport = KReportContext.kReports.getKRport(kreportName);
				if(kReport==null){
					continue;
				}
				PageData pageData = SqlQuery.Query(kReport,param,KReportContext.exportMaxRows);
				
				WritableSheet sheet = workbook.createSheet(kReport.getDisplayName(), sheetIndex++);
				if(StringUtil.isBlank(kReport.getData().getExportModel())){
					ExcelUtil.createTitleLine(pageData.getHead(),	sheet, areaTitleFormat);
							
					int index=1;
					for(String[] obj:pageData.getBodys()){
						ExcelUtil.createLine(obj, index++, sheet, rowFormat);	
					}
				}else{
					String[] cols = kReport.getData().getExportModel().split(",");
					List<Integer> shows = new ArrayList<Integer>();
					for(int i=0;i<cols.length;i++){
						String colName = cols[i].trim();
						for(int j=0;j<pageData.getHead().length;j++){
							if(("${"+j+"}").equals(colName)||("${"+pageData.getHead()[j]+"}").equals(colName)){
								shows.add(j);
							}
						}
					}
					
					ExcelUtil.createTitleLine(pageData.getHead(),	sheet, areaTitleFormat);
					
					int index=1;
					for(String[] obj:pageData.getBodys()){
						ExcelUtil.createLine(obj, index++, sheet, rowFormat);	
					}					
				}
				
			}
			workbook.write();
			workbook.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		out.close();

	}
	
	
	private String[] getSubArray(String[] array, List<Integer> shows){
		String[] sub = new String[shows.size()];
		for(int i=0;i<shows.size();i++){
			sub[i]=array[shows.get(i)];
		}
		return sub;
	}

}
