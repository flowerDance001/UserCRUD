package com.csy.service.order.base;

import java.io.Serializable;

public interface Order extends Serializable {
	/**
	* 校验入参
	*/
	public void check();
}
