package com.csy.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;








import org.springframework.web.servlet.ViewResolver;

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
    * 用户界面
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
	    //分页
	    PageUtil.setPageResultToModel(queryUserList, modelMap);
	     
	    List<UserPojo> pageList = queryUserList.getPageList();
	    
	    modelMap.put("userList", pageList);
	     
       //modelMap.addAttribute("user", user);  
       
       return "jsp/showUser.jsp";  
   }  
   
   
   
   /***
    * 测试testFreeMarker
    * @param request
    * @param response
    * @param modelMap
    * @return
    * @throws Exception
    */
   @RequestMapping("/testFreeMarker")  
   public String testFreeMarker(HttpServletRequest request, HttpServletResponse response,
		   ModelMap modelMap) throws Exception {
	   
	    modelMap.put("user", "csy");
       
       return "testFreeMarke.ftl";  
   }  
   
   /***
    * 保存用户
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
   public String getUserByUserName(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) throws Exception {
	   
	   
	   JSONObject json = new JSONObject();
	   
	   String userName = request.getParameter("userName"); 
	   if (userName==null&&!"".equals(userName)) {
		   return null;
	   }
	   
       //查询用户，根据用户名
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
    * 查询用户根据userId
    * @param request
    * @param response
    * @param modelMap
    * @return
    * @throws Exception
    */
   @RequestMapping("/getUserByUserId")  
   public String getUserByUserId(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) throws Exception {
	   
	   
	   JSONObject json = new JSONObject();
	   
	   String userId = request.getParameter("userId"); 
	   if (userId==null&&!"".equals(userId)) {
			json.put("code", "0");
			json.put("msg", "缺少重要参数");
			printHttpResponse(response, json);
		   return null;
	   }
	   //更具id查询用户
	   
       UserPojo userById = userService.getUserById(Integer.parseInt(userId));
       

       
       //modelMap.addAttribute("user", user);  

		if (userById!=null&&userById.getUserId()>0) {
			json.put("code", "1");
			json.put("user", userById);
		} else {
			json.put("code", "0");
			json.put("msg", "该用户不存在");
		}
		
		printHttpResponse(response, json);
	    
       return null;  
   }  
   
   
   /***
    * 删除用户
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
		   json.put("msg", "缺少总要参数");
	   }
	   
	   
       //根据id删除用户
       int updateUser = userService.deleteUserById(Integer.parseInt(userId));

       //modelMap.addAttribute("user", user);  

		if (updateUser>0) {
			json.put("code", "1");
			json.put("msg", "删除成功");
		} else {
			json.put("code", "0");
			json.put("msg", "删除失败");
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