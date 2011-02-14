/**
 * Created on 2010-6-9
 * @version v1.0
 *
 */
package cn.blsoft.krport.po;

import java.util.List;

/**
 * <p>Title:  PageDate.java</p>    
 * <p>Description: </p>
 *
 * @author wangzhiping
 */
public class PageData {
	
	public PageData(){};
	
		

	public PageData(String[] head, List<String[]> bodys) {
		this.head = head;
		this.bodys = bodys;
	}




	public PageData(Integer page, Integer pageSize, Integer count, String[] head, int[] headType, List<String[]> bodys) {
		this.page = page;
		this.pageSize = pageSize;
		this.count = count;
		this.head = head;
		this.headType=headType;
		this.bodys = bodys;
	}
	

	public PageData(Integer page, Integer pageSize, Integer count, String[] head, int[] headType, List<String[]> bodys, Object[] foot) {
		this.page = page;
		this.pageSize = pageSize;
		this.count = count;
		this.head = head;
		this.headType=headType;
		this.bodys = bodys;
		this.foot = foot;
	}

	/**
	 * 当前页
	 */
	private Integer page;
	
	/**
	 * 页记录数
	 */
	private Integer pageSize;
	
	/**
	 * 总记录数
	 */
	private Integer count;
	
	/**
	 * 标题行数据
	 */
	private String[] head; 	

	/**
	 * 标题行数据类型
	 */
	private int[] headType; 

	/**
	 * 内容行数据
	 */
	private List<String[]> bodys;
	
	/**
	 * 行尾数据
	 */
	private Object[] foot;

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the head
	 */
	public String[] getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(String[] head) {
		this.head = head;
	}

	/**
	 * @return the bodys
	 */
	public List<String[]> getBodys() {
		return bodys;
	}

	/**
	 * @param bodys the bodys to set
	 */
	public void setBodys(List<String[]> bodys) {
		this.bodys = bodys;
	}


	/**
	 * @return the foot
	 */
	public Object[] getFoot() {
		return foot;
	}


	/**
	 * @param foot the foot to set
	 */
	public void setFoot(Object[] foot) {
		this.foot = foot;
	}



	/**
	 * @return the headType
	 */
	public int[] getHeadType() {
		return headType;
	}



	/**
	 * @param headType the headType to set
	 */
	public void setHeadType(int[] headType) {
		this.headType = headType;
	}
	
	

}
