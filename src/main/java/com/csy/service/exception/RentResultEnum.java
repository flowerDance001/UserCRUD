/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.csy.service.exception;

import java.util.ArrayList;
import java.util.List;

public enum RentResultEnum {
	
	/** 未知异常 */
	UN_KNOWN_EXCEPTION("UN_KNOWN_EXCEPTION", "未知异常"),
	/** 请求参数不完整 */
	INCOMPLETE_REQ_PARAM("INCOMPLETE_REQ_PARAM", "请求参数不完整"),
	/** 数据库异常 */
	DATABASE_EXCEPTION("DATABASE_EXCEPTION", "数据库异常"),
	/** 没有数据 */
	HAVE_NOT_DATA("HAVE_NOT_DATA", "没有数据"),
	
	/** 该用户对该数据无访问权限 */
	NO_ACCESS("NO_ACCESS", "该用户对该数据无访问权限"),
	
	/** 数据处理状态不对或已经处理完成 */
	DO_ACTION_STATUS_ERROR("DO_ACTION_STATUS_ERROR", "数据处理状态不对或已经处理完成"),
	/** 执行成功 */
	EXECUTE_SUCCESS("EXECUTE_SUCCESS", "执行成功"),
	
	/** 执行失败 */
	EXECUTE_FAILURE("EXECUTE_FAILURE", "执行失败");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>EstateResultEnum</code>枚举对象
	 * 
	 * @param code
	 * @param message
	 */
	private RentResultEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 * 
	 * @param code
	 * @return EstateResultEnum
	 */
	public static RentResultEnum getByCode(String code) {
		for (RentResultEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<EstateResultEnum>
	 */
	public List<RentResultEnum> getAllEnum() {
		List<RentResultEnum> list = new ArrayList<RentResultEnum>();
		for (RentResultEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (RentResultEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}
