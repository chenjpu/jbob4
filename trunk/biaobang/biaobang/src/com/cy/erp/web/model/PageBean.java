package com.cy.erp.web.model;

public class PageBean {
	public int allPageCount = 0;// 总的页数
	public int currPageIndex = 0;// 当前页的序号
	public int rowCount = 20;// 每页的行数
	public int recordCount;// 记录总数
	public String field = "";// 排序的字段名
	public int desc = 0;// 排序方式：0不排序，1从小到大，2从大到小

	public int getAllPageCount() {
		allPageCount = (int) Math.floor(this.recordCount / this.rowCount);
		if (this.recordCount % this.rowCount != 0) {
			allPageCount++;
		}
		return allPageCount;
	}

	public void setAllPageCount(int allPageCount) {
		this.allPageCount = allPageCount;
	}

	public int getCurrPageIndex() {
		return currPageIndex;
	}

	public void setCurrPageIndex(int currPageIndex) {
		this.currPageIndex = currPageIndex;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public int getDesc() {
		return desc;
	}

	public void setDesc(int desc) {
		this.desc = desc;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
}
