/**
 * Created on 2010-6-7
 * @version v1.0
 *
 */
package cn.blsoft.krport.util;

import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * <p>Title:  ExcelUtil.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class ExcelUtil {
	
	/**
	 * Description: Excel标题行
	 * @param titles 行值
	 * @param sheet 工作表
	 * @param areaTitleFormat 样式
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	public static void createTitleLine(String[] titles, WritableSheet sheet,
			WritableCellFormat areaTitleFormat) throws WriteException,
			RowsExceededException {
		for (int i = 0; i < titles.length; i++) {
			sheet.addCell(new Label(i, 0, titles[i], areaTitleFormat));
		}
	}

	/**
	 * Description: Excel行
	 * @param contants 行值
	 * @param rowNumber 行号
	 * @param sheet 工作表
	 * @param rowFormat 样式
	 * @throws WriteException
	 * @throws RowsExceededException
	 */
	public static void createLine(String[] contants, int rowNumber,
			WritableSheet sheet, WritableCellFormat rowFormat)
			throws WriteException, RowsExceededException {
		for (int i = 0; i < contants.length; i++) {
			sheet.addCell(new Label(i, rowNumber, contants[i], rowFormat));
		}
	}
}
