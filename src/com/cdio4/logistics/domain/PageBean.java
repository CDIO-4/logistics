package com.cdio4.logistics.domain;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	private int currentPage;
	private int pageSize=5;
	private int totalRows;
	private int totalPage;
	private List list=new ArrayList();
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPage() {
		
		return totalRows%pageSize==0?totalRows/pageSize:(totalRows/pageSize)+1;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	

}
