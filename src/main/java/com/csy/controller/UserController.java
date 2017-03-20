package com.csy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csy.controller.util.PageUtil;
import com.csy.pojo.UserPojo;
import com.csy.service.UserService;
import com.csy.service.order.UserOrder;
import com.csy.service.result.QueryBaseBatchResult;
 

@Controller  
@RequestMapping("/user")  
public class UserController {  
   @Resource  
   private UserService userService;  
     
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
	    //“≥√Ê∑÷“≥
	    PageUtil.setPageResultToModel(queryUserList, modelMap);
	     
	    List<UserPojo> pageList = queryUserList.getPageList();
	    
	    modelMap.put("userList", pageList);
	     
       //modelMap.addAttribute("user", user);  
       
       return "showUser";  
   }  
   
   
   @RequestMapping("/showUserById")  
   public String showUserById(HttpServletRequest request, HttpServletResponse response,
			ModelMap modelMap) throws Exception {
	   
	   
	   UserPojo user = userService.getUserById(273);
	     
       modelMap.addAttribute("user", user);  
       
       return "showUser";  
   }  
   
   
}