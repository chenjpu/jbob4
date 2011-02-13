package test;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.cy.erp.web.dataGate.Globe;

public class TestOracle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultSet rs1 = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// String connectionUrl =
			// "jdbc:oracle:thin:@10.17.37.209:1521:ora10";
			String connectionUrl = "jdbc:oracle:thin:@10.17.34.220:1521:ora10g";

			Connection con = DriverManager.getConnection(connectionUrl,
					"inas2", "inas2");
			Statement stmt = con
					.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			CallableStatement cstmt = con.prepareCall("{call TESTC(?,?)}");

			// cstmt.setString(1, "SELECT COUNT(T.ID) as C FROM
			// T_WORKORDER_CUR_HIS T");
			cstmt
					.setString(
							1,
							"SELECT * FROM(SELECT A.*, ROWNUM RN FROM (select his.* from t_workorder_cur_his his where 1=1 and his.WORKORDER_TYPE_ID in ('0','01','02','03','04','05','06','07','08','10','11','15','19','20','66','99')) A WHERE ROWNUM < 10)WHERE RN >= 0");
//			cstmt.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();
			rs1 = (ResultSet) cstmt.getObject(2);
			int i = 0;
			while (rs1.next()) {
				// 获取返回对像所有的字段对应的值
				// System.out.print(rs1.getString(1));
				// System.out.print(" ");
				// System.out.print(rs1.getString(2));
				// System.out.print(" ");
				// System.out.print(rs1.getString(3));
				// System.out.print(" ");
				// System.out.println(rs1.getString(4));
				// System.out.println();
				i += 1;
			}
			System.out.println("总记录数：" + i);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (rs1 != null) {
				try {
					rs1.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
					Globe.logger.error(ex.getMessage());
				}
			}
		}
	}

	public void createSheet(HSSFWorkbook wb, long rptno, String filename,
			HttpServletResponse response) {
		try {

			SAXBuilder sb = new SAXBuilder();
			Document doc = sb.build(new File(filename));

			String excelname = "report_" + rptno + ".xls";
			String sheetname = "report_" + rptno;
			HSSFSheet sheet = wb.createSheet(sheetname);

			Element root = doc.getRootElement();
			List list = root.getChildren();

			HSSFCellStyle headingCellStyle = wb.createCellStyle();
			headingCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFFont headingCellFont = wb.createFont();
			headingCellFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			headingCellStyle.setFont(headingCellFont);
			HSSFRow row;
			row = sheet.createRow((short) 0);
			if (list != null && list.size() > 0) {
				Element element = (Element) list.get(0);
				int length = element.getChildren().size();
				for (int i = 0; i < length; i++) {
					String columnName = ((Element) element.getChildren().get(i))
							.getName();
					if (columnName == null)
						columnName = "";
					else if (columnName.length() >= 1)
						columnName = columnName.substring(0, 1).toUpperCase()
								+ columnName.substring(1);
					HSSFCell cell = row.createCell((short) (i));
					cell.setCellValue(columnName);
					cell.setCellStyle(headingCellStyle);
				}
			}

			short rowIndex = 0;
			for (int i = 0; i < list.size(); i++) {
				Element section = (Element) list.get(i);
				List sect = section.getChildren();
				row = sheet.createRow((short) ++rowIndex);
				for (int colIndex = 0; colIndex < sect.size(); colIndex++) {
					HSSFCell cell = row.createCell((short) colIndex);
					cell.setCellValue(((Element) sect.get(colIndex)).getText());
				}
			}
			writeExcelFile(wb, response, excelname);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void writeExcelFile(HSSFWorkbook wb, HttpServletResponse response,
			String fileName) throws IOException {

		response.reset();
		ServletOutputStream sos = response.getOutputStream();
		response.setContentType("application/ms-excel");
		response.setHeader("Content-disposition", "attachment; filename="
				+ fileName);
		wb.write(sos);
		sos.flush();
		sos.close();
	}
}
