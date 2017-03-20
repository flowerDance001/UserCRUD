package com.csy.service.order.base;

import org.springframework.util.Assert;

public class ValidateOrderBase implements Order {
	
	/** Comment for <code>serialVersionUID</code> */
	private static final long	serialVersionUID	= -4636701837799484290L;
	private String				urlString;
	
	public String getUrlString() {
		return urlString;
	}
	
	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}
	
	protected void validateHasText(String validateField, String fieldDes) {
		Assert.hasText(validateField, fieldDes + "不能为空!");
	}
	
	protected void validateHasZore(long vlaue, String fieldDes) {
		Assert.isTrue(vlaue > 0, fieldDes + "不能为空!");
	}
	
	protected void validateNotNull(Object validateField, String fieldDes) {
		Assert.notNull(validateField, fieldDes + "不能为空!");
	}
	
	protected void validateGreaterThan(Number validateField, String fieldDes) {
		Assert.isTrue(validateField.doubleValue() > 0, fieldDes + "必须大于零!");
	}
	
	@Override
	public void check() {
	}
}
