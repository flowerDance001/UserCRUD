package com.csy.controller.base;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;

import com.csy.pojo.UserPojo;

public abstract class BaseController  {
	
	protected Logger					logger			= LoggerFactory.getLogger(getClass());
	
	public static final String			ERROR_MESSAGE	= "errorMessage";
	
	public void renderErrMsg(String msgs, ModelMap modelMap) {
		
		String[] errMsg = msgs.split("#");
		for (String msgMap : errMsg) {
			String[] msg = msgMap.split(">");
			modelMap.put(msg[0], msg[1]);
		}
	}
	
	public UserPojo getUser(HttpServletRequest request) {
		UserPojo userPojo = new UserPojo();
		 	String 	realName = request.getParameter("realName"); 
		 	userPojo.setRealName(realName);
		 	
	       String	userName  = request.getParameter("userName"); 
	       userPojo.setUserName(userName);
	       
	       String  	userInfo = request.getParameter("userInfo"); 
	       userPojo.setUserInfo(userInfo);
	       
	       String  	telNo = request.getParameter("telNo"); 
	       userPojo.setTelNo(telNo);
	       
	       String 	qqNo = request.getParameter("qqNo");
	       userPojo.setQqNo(qqNo);
	       
	       String  	emailNo = request.getParameter("emailNo"); 
	       userPojo.setEmailNo(emailNo);
	       
	       String  	idCard = request.getParameter("idCard"); 
	       userPojo.setIdCard(idCard);
	       
	       String 	disableReason = request.getParameter("disableReason");
	       userPojo.setDisableReason(disableReason);
		
		return userPojo;
		
	}
	
	protected void printHttpResponse(HttpServletResponse response, JSONObject json) {
		try {
			response.setContentType("json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().println(json.toJSONString());
		} catch (IOException e) {
			logger.error("response. getWriter print error ", e);
		}
	}
	
	/**
	 * 将对象放到Session�?
	 * 
	 * @param request
	 * @param key
	 * @param obj
	 */
	public void setSession(HttpServletRequest request, String key, Object obj) {
		request.getSession().setAttribute(key, obj);
	}
	
	/**
	 * 从Session中取对象
	 * 
	 * @param request
	 * @param key
	 */
	public Object getSession(HttpServletRequest request, String key) {
		if (request != null) {
			return request.getSession().getAttribute(key);
		}
		return null;
	}
	
	/**
	 * 移除Session中的对象
	 * 
	 * @param request
	 * @param key
	 */
	public void removeSession(HttpServletRequest request, String key) {
		if (request != null) {
			request.getSession().removeAttribute(key);
		}
	}
	
	/**
	 * 取用户IP
	 * 
	 * @param request
	 */
	public String clientIP(HttpServletRequest request) {
		return request.getRemoteAddr();
	}
	
	
}
