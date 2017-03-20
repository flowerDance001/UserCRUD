package com.csy.service.order.base;

import org.springframework.util.Assert;

public class QueryBaseOrder extends ValidateOrderBase implements Order, QueryOrderInterface {
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 1098188159323046396L;
	long						pageSize			= 10;
	long						pageNumber			= 1;
	
	@Override
	public long getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public long getPageNumber() {
		return pageNumber;
	}
	
	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	@Override
	public void check() {
		Assert.isTrue(pageNumber > 0, "无效分页参数");
		Assert.isTrue(pageSize > 0, "无效分页参数");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("QueryBaseOrder [pageSize=");
		builder.append(pageSize);
		builder.append(", pageNumber=");
		builder.append(pageNumber);
		builder.append("]");
		return builder.toString();
	}
	
}
