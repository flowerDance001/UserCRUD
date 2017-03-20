package com.csy.service.result;

import java.util.List;

import com.csy.service.order.base.PageComponent;

public class QueryBaseBatchResult<T> extends RentBaseResult {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 420002915574977408L;
	long						totalCount			= 0;
	long						pageSize			= 10;
	long						pageNumber			= 1;
	List<T>						pageList;
	long						listtotalmenber		= 0;
	
	public void initPageParam(PageComponent component) {
		this.setTotalCount(component.getRowCount());
		this.setPageSize(component.getPageSize());
		this.setPageNumber(component.getCurPage());
	}
	
	public long getListtotalmenber() {
		return listtotalmenber;
	}
	
	public void setListtotalmenber(long listtotalmenber) {
		this.listtotalmenber = listtotalmenber;
	}
	
	public List<T> getPageList() {
		return pageList;
	}
	
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	
	public long getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public long getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	
	public long getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryBaseBatchResult [totalCount=");
		builder.append(totalCount);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", pageNumber=");
		builder.append(pageNumber);
		builder.append(", pageList=");
		builder.append(pageList);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
