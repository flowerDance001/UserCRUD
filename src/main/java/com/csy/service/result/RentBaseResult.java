/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.csy.service.result;

import com.csy.service.exception.RentResultEnum;


public class RentBaseResult extends ResultBase {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -4464270484225974165L;
	
	/**返回结果码*/
	RentResultEnum				rentResultEnum		= RentResultEnum.UN_KNOWN_EXCEPTION;
	
	String						bizNo;
	
	public String getBizNo() {
		return bizNo;
	}
	
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	
	@Override
	public boolean isExecuted() {
		
		return RentResultEnum.EXECUTE_SUCCESS == rentResultEnum ? true : false;
	}
	
	public RentResultEnum getRentResultEnum() {
		return rentResultEnum;
	}
	
	public void setRentResultEnum(RentResultEnum estateResultEnum) {
		this.rentResultEnum = estateResultEnum;
		if (this.rentResultEnum != null) {
			if ( "".equals(this.getMessage())) {
				this.setMessage(this.rentResultEnum.getMessage());
			}
			
		}
	}
	
	@Override
	public void setSuccess(boolean success) {
		super.setSuccess(success);
		if (success)
			rentResultEnum = RentResultEnum.EXECUTE_SUCCESS;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RentBaseResult [rentResultEnum=");
		builder.append(rentResultEnum);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
