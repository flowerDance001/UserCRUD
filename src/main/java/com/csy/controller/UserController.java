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
    * 用户列表
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
       
       if (realName!=null&&!"".equals(realName)) {
    	   modelMap.put("realName", realName);
    	   order.setRealName("%"+realName+"%");
       }
       
       QueryBaseBatchResult<UserPojo> queryUserList = userService.queryUserList(order);
      
       System.out.println(queryUserList);
	    //页面分页
	    PageUtil.setPageResultToModel(queryUserList, modelMap);
	     
	    List<UserPojo> pageList = queryUserList.getPageList();
	    
	    modelMap.put("userList", pageList);
	     
       //modelMap.addAttribute("user", user);  
       
       return "showUser";  
   }  
   
   
   /***
    * 插入用户
    * @param request
    * @param response
    * @param modelMap
    * @return
    * @throws Exception
    */
   @RequestMapping("/insertUser")  
   public String insertUser(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) throws Exception {
	   
	   
	   JSONObject json = new JSONObject();
	   
	   UserPojo user = getUser(request);
	   
       //插入数据
       int insterUser = userService.insterUser(user);

       //modelMap.addAttribute("user", user);  

		if (insterUser>1) {
			json.put("code", "1");
			json.put("msg", "添加用户成功");
			
		} else {
			json.put("code", "0");
			json.put("msg", "添加用户失败");
		}
		
		printHttpResponse(response, json);
		
	    
       return null;  
   }  
   
   /***
    * 修改用户信息
    * @param request
    * @param response
    * @param modelMap
    * @return
    * @throws Exception
    */
   @RequestMapping("/updateUser")  
   public String updateUser(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) throws Exception {
	   
	   
	   JSONObject json = new JSONObject();
	   
	   String userId = request.getParameter("userId"); 
	   if (userId==null&&!"".equals(userId)) {
		   json.put("code", "0");
		   json.put("msg", "缺少总要参数");
	   }
	   UserPojo user = getUser(request);
	   
       //插入数据
       int updateUser = userService.updateUser(user);

       //modelMap.addAttribute("user", user);  

		if (updateUser>1) {
			json.put("code", "1");
			json.put("msg", "修改用户成功");
		} else {
			json.put("code", "0");
			json.put("msg", "修改用户失败");
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
	   
	   
       //插入数据
       int updateUser = userService.deleteUserById(Integer.parseInt(userId));

       //modelMap.addAttribute("user", user);  

		if (updateUser>1) {
			json.put("code", "1");
			json.put("msg", "删除用户成功");
		} else {
			json.put("code", "0");
			json.put("msg", "删除用户失败");
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