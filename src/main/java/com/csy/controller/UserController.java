package com.csy.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;







import com.csy.controller.base.BaseController;
import com.csy.controller.util.PageUtil;
import com.csy.pojo.UserPojo;
import com.csy.service.UserService;
import com.csy.service.order.UserOrder;
import com.csy.service.result.QueryBaseBatchResult;

 

@Controller  
@RequestMapping("/user")  
public class UserController extends BaseController{  
   @Resource  
   private UserService userService;  
     
   /***
    * �û��б�
    * @param request
    * @param response
    * @param modelMap
    * @return
    * @throws Exception
    */
   @RequestMapping("/showUser")  
   public String showUser(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) throws Exception {
	   
	   
	   UserOrder order = new UserOrder();
	   
       String realName = request.getParameter("realName"); 
       String pageNumber = request.getParameter("pageNumber");
       if (pageNumber!=null) {
		int parseInt = Integer.parseInt(pageNumber);
		
		if (parseInt<1) {
			parseInt=1;
		}
		order.setPageNumber(parseInt);
       }
       if (realName!=null&&!"".equals(realName)) {
    	   modelMap.put("realName", realName);
    	   order.setRealName("%"+realName+"%");
       }
       
       QueryBaseBatchResult<UserPojo> queryUserList = userService.queryUserList(order);
      
       System.out.println(queryUserList);
	    //ҳ���ҳ
	    PageUtil.setPageResultToModel(queryUserList, modelMap);
	     
	    List<UserPojo> pageList = queryUserList.getPageList();
	    
	    modelMap.put("userList", pageList);
	     
       //modelMap.addAttribute("user", user);  
       
       return "showUser";  
   }  
   
   
   /***
    * �����û�
    * @param request
    * @param response
    * @param modelMap
    * @return
    * @throws Exception
    */
   @RequestMapping("/saveUser")  
   public String insertUser(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) throws Exception {
	   
	   
	   JSONObject json = new JSONObject();
	   
	   UserPojo user = getUser(request);
	   
	   String userId = request.getParameter("userId");
	   
	   int save = 0;
	   
	   user.setUserPwd("888888");
	   if (userId==null||"".equals(userId)) {
		   //�������
		    save = userService.insterUser(user);
	   }else {
		   user.setUserId(Integer.parseInt(userId));
		    save = userService.updateUser(user);
	   }
	   

       //modelMap.addAttribute("user", user);  

		if (save>0) {
			json.put("code", "1");
			json.put("msg", "保存成功");
			
		} else {
			json.put("code", "0");
			json.put("msg", "保存失败");
		}
		
		printHttpResponse(response, json);
		
	    
       return null;  
   }  
   
   /***
    * 查询用户根据用户名
    * @param request
    * @param response
    * @param modelMap
    * @return
    * @throws Exception
    */
   @RequestMapping("/getUserByUserName")  
   public String updateUser(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) throws Exception {
	   
	   
	   JSONObject json = new JSONObject();
	   
	   String userName = request.getParameter("userName"); 
	   if (userName==null&&!"".equals(userName)) {
		   return null;
	   }
	   
       //�������
       UserPojo userByName = userService.getUserByName(userName);

       
       //modelMap.addAttribute("user", user);  

		if (userByName!=null&&userByName.getUserId()>0) {
			json.put("code", "1");
		} else {
			json.put("code", "0");
		}
		
		printHttpResponse(response, json);
	    
       return null;  
   }  
   
   
   /***
    * ɾ���û�
    * @param request
    * @param response
    * @param modelMap
    * @return
    * @throws Exception
    */
   @RequestMapping("/deleteUser")  
   public String deleteUser(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) throws Exception {
	   
	   
	   JSONObject json = new JSONObject();
	   
	   String userId = request.getParameter("userId"); 
	   if (userId==null&&!"".equals(userId)) {
		   json.put("code", "0");
		   json.put("msg", "ȱ����Ҫ����");
	   }
	   
	   
       //�������
       int updateUser = userService.deleteUserById(Integer.parseInt(userId));

       //modelMap.addAttribute("user", user);  

		if (updateUser>1) {
			json.put("code", "1");
			json.put("msg", "ɾ���û��ɹ�");
		} else {
			json.put("code", "0");
			json.put("msg", "ɾ���û�ʧ��");
		}
		
		printHttpResponse(response, json);
	    
       return null;  
   }  
   
   @RequestMapping("/showUserById")  
   public String showUserById(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) throws Exception {
	   
	   
	   UserPojo user = userService.getUserById(273);
	     
       modelMap.addAttribute("user", user);  
       
       return "showUser";  
   }  
   
   
}