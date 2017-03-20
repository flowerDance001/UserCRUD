/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package com.csy.controller.util;

import org.springframework.ui.ModelMap;

import com.alibaba.fastjson.JSONObject;
import com.csy.service.base.RentPage;
import com.csy.service.result.QueryBaseBatchResult;

public class PageUtil {
	@SuppressWarnings("rawtypes")
	public static void setPageResultToModel(QueryBaseBatchResult queryResult, ModelMap modelMap) {
		if (queryResult.isSuccess()) {
			@SuppressWarnings("unchecked")
			RentPage page = new RentPage(queryResult.getPageNumber(), queryResult.getTotalCount(),
				queryResult.getPageSize(), queryResult.getPageList());
			modelMap.put("page", page);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void setPageResultToJson(QueryBaseBatchResult queryResult, JSONObject json) {
		if (queryResult.isSuccess()) {
			@SuppressWarnings("unchecked")
			RentPage page = new RentPage(queryResult.getPageNumber(), queryResult.getTotalCount(),
				queryResult.getPageSize(), queryResult.getPageList());
			json.put("page", page);
		}
	}
}
