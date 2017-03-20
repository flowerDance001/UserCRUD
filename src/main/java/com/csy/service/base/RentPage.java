/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.csy.service.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class RentPage<T> {
	private static int	DEFAULT_PAGE_SIZE	= 20;
	
	private long		pageSize			= DEFAULT_PAGE_SIZE;	//// 每页的记录数，<=0表示只有一页。
																	
	private long		start;										// 当前页第一条数据在"数据集"中的位置,从0开始
	private long		startIndex;								// 当前页第一条数据显示值，没数据显示0
																	
	private List<T>		result;									// 当前页中存放的记录,类型一般为List
																	
	private long		totalCount;								// 总记录数
																	
	private long		totalPageCount;
	
	private long		currentPageNo;
	
	@SuppressWarnings("unused")
	private long		previosPageNo;
	
	@SuppressWarnings("unused")
	private long		nexPagetNo;
	
	private boolean		isViewNextTens		= false;
	private boolean		isViewPreTens		= false;
	private final long	isViewNumber		= 10;
	private long		startPage;
	private long		endPages;
	private long		preTenPages;
	private long		nextTenPages;
	
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	public void setTotalPageCount(long totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	public void setCurrentPageNo(long currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	
	/**
	* 构造方法，只构造空页.
	*/
	public RentPage() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<T>());
	}
	
	/**
	 * 默认构造方法.
	 * 
	 * @param pageNumber 
	 * 					当前页面
	 * @param totalSize
	 *                数据库中总记录条数，必须>=0。
	 * @param pageSize
	 *                本页容量，<=0表示只有一页。
	 * @param data
	 *                本页包含的数据，不能为 null 。
	 */
	public RentPage(long pageNumber, long totalCount, long pageSize, List<T> result) {
		
		//检查参数。
		Assert.state(pageNumber >= 0);
		Assert.state(totalCount >= 0);
		Assert.notNull(result);
		//初始化参数。
		initliazer(pageNumber, totalCount, pageSize, result);
	}
	
	private void initliazer(long pageNumber, long totalCount, long pageSize, List<T> result) {
		this.start = (pageNumber - 1) * pageSize;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.result = result;
		this.previosPageNo = getPreviosPageNo();
		this.nexPagetNo = getNexPagetNo();
		//计算总页数
		this.totalPageCount = (totalCount == 0 || this.pageSize <= 0) ? 1
			: (totalCount + (this.pageSize - 1)) / this.pageSize;
		//计算当前页
		this.currentPageNo = pageNumber;
		//当前页面count记录数
		//		long currentCount = this.currentPageNo * this.pageSize;
		//		if (this.currentPageNo % isViewNumber < isViewNumber / 2) {
		//			
		//		} else {
		//			startPage = (this.currentPageNo / isViewNumber + 1) * isViewNumber - 1;
		//		}
		startPage = this.currentPageNo % isViewNumber == 0 ? (this.currentPageNo / isViewNumber - 1)
																* isViewNumber + 1
			: (this.currentPageNo / isViewNumber) * isViewNumber + 1;
		endPages = startPage + isViewNumber - 1;
		if (endPages >= totalPageCount)
			endPages = totalPageCount;
		else {
			isViewNextTens = true;
			nextTenPages = endPages + 1;
		}
		if (startPage > isViewNumber) {
			isViewPreTens = true;
			preTenPages = startPage - 1;
		}
		
		if (this.totalCount == 0) {
			this.startIndex = 0;
		} else
			this.startIndex = this.start + 1;
	}
	
	/**
	 * 取总记录数.
	 */
	public long getTotalCount() {
		return this.totalCount;
	}
	
	public long getPageSize() {
		return pageSize;
	}
	
	/**
	 * 取总页数。如果totalSize为0或pageSize<=0，返回1。
	 */
	public long getTotalPageCount() {
		return totalPageCount;
	}
	
	/**
	 * 取当前页中指定记录
	 * 
	 * @param index
	 *                以0为起始值
	 * @return
	 */
	public Object getEntity(int index) {
		if (result != null && result.size() > index) {
			return result.get(index);
		}
		return null;
	}
	
	/**
	 * 获取结果
	 */
	public List<T> getResult() {
		return result;
	}
	
	public void setResult(List<T> result) {
		this.result = result;
	}
	
	/**
	 * 取该页当前页码，页码从1开始。如果pageSize<=0，返回1。
	 */
	public long getCurrentPageNo() {
		return currentPageNo;
	}
	
	/**
	 * 该页是否有下一页.
	 */
	public boolean hasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount();
	}
	
	/**
	 * 是否有前一页
	 */
	public boolean hasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}
	
	/**
	 * 获取任一页第一条数据在数据集的位置，每页条数使用默认值.
	 * 
	 * @see #getStartOfPage(int,int)
	 */
	protected static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}
	
	/**
	 * 获取任一页第一条数据在数据集的位置（这个返回的startIndex是从0开始的）.
	 * 
	 * @param pageNo
	 *                从1开始的页号
	 * @param pageSize
	 *                每页记录条数
	 * @return 该页第一条数据
	 */
	public static int getStartOfPage(int pageNo, int pageSize) {
		if (pageSize <= 0) {
			return 0;
		} else {
			return (pageNo - 1) * pageSize;
		}
	}
	
	public long getPreviosPageNo() {
		
		return getCurrentPageNo() - 1 < 1 ? 1 : getCurrentPageNo() - 1;
		
	}
	
	public long getNexPagetNo() {
		return getCurrentPageNo() + 1 > getTotalPageCount() ? getTotalPageCount()
			: getCurrentPageNo() + 1;
	}
	
	public long getStart() {
		return start;
	}
	
	public boolean isViewNextTens() {
		return isViewNextTens;
	}
	
	public void setViewNextTens(boolean isViewNextTens) {
		this.isViewNextTens = isViewNextTens;
	}
	
	public boolean isViewPreTens() {
		return isViewPreTens;
	}
	
	public void setViewPreTens(boolean isViewPreTens) {
		this.isViewPreTens = isViewPreTens;
	}
	
	public long getStartPage() {
		return startPage;
	}
	
	public void setStartPage(long startPage) {
		this.startPage = startPage;
	}
	
	public long getEndPages() {
		return endPages;
	}
	
	public void setEndPages(long endPages) {
		this.endPages = endPages;
	}
	
	public long getPreTenPages() {
		return preTenPages;
	}
	
	public void setPreTenPages(long preTenPages) {
		this.preTenPages = preTenPages;
	}
	
	public long getNextTenPages() {
		return nextTenPages;
	}
	
	public void setNextTenPages(long nextTenPages) {
		this.nextTenPages = nextTenPages;
	}
	
	public long getIsViewNumber() {
		return isViewNumber;
	}
	
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}
	
	public void setStart(long start) {
		this.start = start;
	}
	
	public void setPreviosPageNo(long previosPageNo) {
		this.previosPageNo = previosPageNo;
	}
	
	public void setNexPagetNo(long nexPagetNo) {
		this.nexPagetNo = nexPagetNo;
	}
	
	public long getStartIndex() {
		return startIndex;
	}
	
	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RentPage [pageSize=");
		builder.append(pageSize);
		builder.append(", start=");
		builder.append(start);
		builder.append(", startIndex=");
		builder.append(startIndex);
		builder.append(", result=");
		builder.append(result);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append(", totalPageCount=");
		builder.append(totalPageCount);
		builder.append(", currentPageNo=");
		builder.append(currentPageNo);
		builder.append(", previosPageNo=");
		builder.append(previosPageNo);
		builder.append(", nexPagetNo=");
		builder.append(nexPagetNo);
		builder.append(", isViewNextTens=");
		builder.append(isViewNextTens);
		builder.append(", isViewPreTens=");
		builder.append(isViewPreTens);
		builder.append(", isViewNumber=");
		builder.append(isViewNumber);
		builder.append(", startPage=");
		builder.append(startPage);
		builder.append(", endPages=");
		builder.append(endPages);
		builder.append(", preTenPages=");
		builder.append(preTenPages);
		builder.append(", nextTenPages=");
		builder.append(nextTenPages);
		builder.append("]");
		return builder.toString();
	}
	

	
}
