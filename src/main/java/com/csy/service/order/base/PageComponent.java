package com.csy.service.order.base;

public class PageComponent {
	public final static int	Page_Count	= 15;
	long					pages;
	long					pageSize	= Page_Count;
	long					curPage;
	long					pageCount;
	long					firstRecord	= 0;
	long					lastRecord	= Page_Count;
	long					rowCount;
	long					firstPage;
	
	public long getPages() {
		return pages;
	}
	
	public long getPageSize() {
		return pageSize;
	}
	
	public long getCurPage() {
		return curPage;
	}
	
	public long getPageCount() {
		return pageCount;
	}
	
	public long getFirstRecord() {
		return firstRecord;
	}
	
	public long getLastRecord() {
		return lastRecord;
	}
	
	public long getRowCount() {
		return rowCount;
	}
	
	public long getFirstPage() {
		return firstPage;
	}
	
	public PageComponent(QueryOrderInterface queryOrder, long rowCount) {
		init(queryOrder.getPageSize(), queryOrder.getPageNumber(), rowCount);
	}
	
	public PageComponent(int iPages, int rowCount) {
		init(pageSize, iPages, rowCount);
	}
	
	public PageComponent(int iPageSize, int iPages, int rowCount) {
		init(iPageSize, iPages, rowCount);
	}
	
	void init(long iPageSize, long iPages, long rowCount) {
		pageSize = iPageSize;
		
		curPage = iPages;
		this.rowCount = rowCount;
		this.pageCount = rowCount % iPageSize == 0 ? rowCount / iPageSize : rowCount / iPageSize
																			+ 1;
		if (this.pageCount == 0) {
			this.pageCount = 1;
		}
		this.curPage = iPages;
		
		if (this.curPage < this.pageCount) {
			this.firstRecord = (this.curPage - 1) * pageSize;
			this.lastRecord = (this.curPage) * pageSize;
		} else {
			this.firstRecord = (this.pageCount - 1) * pageSize;
			this.lastRecord = rowCount;
			this.curPage = this.pageCount;
		}
	}
}
