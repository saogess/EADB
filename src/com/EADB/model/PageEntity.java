package com.EADB.model;

/**
 *����ʱ�䣺2017��9��16������3:11:52
 *��Ŀ���ƣ�20170912_shoppingCart
 *@author Ԫۿ��
 *@version 1.0
 *@since JDK 1.7.0_21
 *�ļ�����:PageEntity.java
 *��˵������ҳ����Ϣ��װ�㡣
 */

public class PageEntity {
	private int pageIndex=1;  //��ǰҳ��Ĭ���ǵ�һҳ
	private int pageSize=5;  //ÿҳ��ʾ������������Ĭ��ÿҳ��ʾ5��
	private int totalPage;   //��ҳ��(�ܼ�¼��/ÿҳ��ʾ���������� ע�� �����������������̣���֮���̼�1)
	private int totalCount;  //�ܼ�¼��
	
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
