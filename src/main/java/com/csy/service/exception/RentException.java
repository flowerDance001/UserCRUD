/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.csy.service.exception;

/**
 *                       
 * @Filename EstateException.java
 *
 * @Description 
 *
 * @Version 1.0
 *
 * @Author peigen
 *
 * @Email peigen@yiji.com
 *       
 * @History
 *<li>Author: peigen</li>
 *<li>Date: 2013-2-3</li>
 *<li>Version: 1.0</li>
 *<li>Content: create</li>
 *
 */
public class RentException extends ApplicationNestException {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= 554229467642044021L;
	
	private RentResultEnum		resultCode;
	
	private String				errorMsg;
	
	/**
	 * æž„å»ºä¸?¸ª<code>EstateException.java</code>
	 */
	public RentException() {
		super();
	}
	
	/**
	 * æž„å»ºä¸?¸ª<code>EstateException.java</code>
	 * @param arg0
	 * @param arg1
	 */
	public RentException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	
	/**
	 * æž„å»ºä¸?¸ª<code>EstateException.java</code>
	 * @param arg0
	 */
	public RentException(String arg0) {
		super(arg0);
	}
	
	/**
	 * æž„å»ºä¸?¸ª<code>EstateException.java</code>
	 * @param arg0
	 */
	public RentException(Throwable arg0) {
		super(arg0);
	}
	
	/**
	 * æž„å»ºä¸?¸ª<code>EstateException.java</code>
	 * @param resultCode
	 * @param errorMsg
	 */
	public RentException(RentResultEnum resultCode, String errorMsg) {
		super();
		this.resultCode = resultCode;
		this.errorMsg = errorMsg;
	}
	
	public RentResultEnum getResultCode() {
		return resultCode;
	}
	
	public void setResultCode(RentResultEnum resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	/**
	 * @return
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RentException [resultCode=");
		builder.append(resultCode);
		builder.append(", errorMsg=");
		builder.append(errorMsg);
		builder.append("]");
		return builder.toString();
	}
	
}
