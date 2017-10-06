package com.EADB.model;

/**
 *创建时间：2017年9月16日下午3:11:52
 *项目名称：20170912_shoppingCart
 *@author 元劭骏
 *@version 1.0
 *@since JDK 1.7.0_21
 *文件名称:PageEntity.java
 *类说明：分页的信息封装层。
 */

public class PageEntity {
	private int pageIndex=1;  //当前页，默认是第一页
	private int pageSize=5;  //每页显示的数据条数，默认每页显示5条
	private int totalPage;   //总页数(总记录数/每页显示的数据条数 注： 如果整除，结果就是商，反之就商加1)
	private int totalCount;  //总记录数
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
