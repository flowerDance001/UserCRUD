<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
      <head>  
        <title>用户crud</title>  
        <link rel="stylesheet" type="text/css" href="/mtest/css/basic.css">
        <script type="text/javascript" src="/mtest/js/jquery-1.7.2.min.js"></script>
         <script type="text/javascript" src="/mtest/js/usereditor/user.js"></script> 
        <script type="text/javascript">
        function goPage(intPage)
	       	{
	       		$("#pageNumber").val(intPage);
	       		$("#queryUserFrom").submit();
	       	}
		       
        </script>
        
      </head>  
      
      <body>  
      
       
      <form action="/mtest/user/showUser" method="post" id="queryUserFrom">
      
        <div class="grzx_top">
			
			<div class="grzx_ss"> 
				真实姓名：<input type="text"  name="realName" value="${realName}" class="text10">  
				<input type="submit" value="查询" class="but15"/>  
				<input type="buttom" value="添加用户" class="but15 tj"/>
			</div>
			
         </div>
         
      
		        <table cellpadding="0" cellspacing="0" class="tab05" >
			        	<tr>
				        	<th>用户名</th>
				        	<th>电话</th>
				        	<th>电子邮件</th>
				        	<th>真实姓名</th>
				        	<th>身份证号码</th>
				        	<th>操作</th>
			        	</tr>
			        <c:forEach var="user" items="${userList}">
			                 <%--用EL表达式调用list对象的属性循环输出对象的各个属性值--%>
			                 <tr>
			                    <td>${user.userName}</td>
			                    <td>${user.telNo}</td>
			                    <td>${user.emailNo}</td>
			                    <td>${user.realName}</td>
			                   	<td>${user.idCard}</td>
			                   	<td>
			                   		<a href="javascript:void(0);" class="bj" userId="${user.userId}" userName="${user.userName}" telNo="${user.telNo}" emailNo="${user.emailNo}" realName="${user.realName}" idCard="${user.idCard}">编辑</a>
			                   		</br>
			                   		<a href="javascript:void(0);" class="sc" userId="${user.userId}" >删除</a>
			                   	</td>
			                  </tr>
					</c:forEach>
			</table>
			
			<input id="pageNumber" name="pageNumber" type="hidden" value="${page.currentPageNo}" />
			<input id="allPages" type="hidden"	value="${page.totalPageCount}" />
			
			<div class="page">
				<a href="javascript:goPage(1)">首页</a>
				
				<c:if test="${page.currentPageNo > 1}">
			    		<a href="javascript:goPage(parseFloat(${page.currentPageNo}) - 1 )" >上一页</a>
		    	</c:if>
		    	
	    		第 ${page.currentPageNo} 页 - 共${page.totalPageCount}页 - 总共有${page.totalCount}条数据

	    		
				<c:if test="${page.currentPageNo < page.totalPageCount}">
		    		<a href="javascript:goPage(parseFloat(${page.currentPageNo}+1))" >下一页</a>
		    	</c:if>
		    	
				<a href="javascript:goPage(${page.totalPageCount})" >尾页</a>
			</div>
		
		</form>
		
	<div class="black" style="display:none;"></div>
	
	<div class="tkbox" id="addAndE" style="display:none; width: 555px;">
	   <table cellpadding="0" cellspacing="0" class="tab02">
			<input type="hidden" name="userId" value="" >
	      <tr><td class="td02" width="130px">用户名：</td><td><input type="text" name="userName" value="" class="text06"> <span style="display:none; color:red;" clss="error"></span></td></tr>
	      <tr><td class="td02">电话：</td><td><input type="text" name="telNo" value="" class="text06"> <span style="display:none; color:red;" clss="error"></span></td></tr>
	      <tr><td class="td02">电子邮件：</td><td><input type="text" name="emailNo" value="" class="text06"> <span style="display:none; color:red;" clss="error"></span></td></tr>
	      <tr><td class="td02">真实姓名：</td><td><input type="text" name="realNameT" value="" class="text06"> <span style="display:none; color:red;" clss="error"></span></td></tr>
	       <tr><td class="td02">身份证号码：</td><td><input type="text" name="idCard" value="" class="text06"> <span style="display:none; color:red;" clss="error"></span></td></tr>
	     
	    </table>
	  <div class="butbox2"><input type="submit" value="保存" class="but12 save" houseStatus="4"><input type="submit" value="取消" class="but13 qx" ></div>
	</div>
	
	
      </body>  
    </html>  