
    <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
    <html>  
      <head>  
        <title>测试</title>  
        <style type="text/css">
       	 	table.tab05{width:96%; height:auto; overflow:hidden; border:1px solid #ededed; border-top:none; border-left:none; margin:15px auto; background:#fff;}
			table.tab05 tr th{ background:#f5f5f6; border-top:1px solid #ededed; border-left:1px solid #ededed; text-align:center; font:normal 14px/20px "微软雅黑"; color:#222; padding:15px 0;}
			table.tab05 tr td{border-top:1px solid #ededed; border-left:1px solid #ededed; text-align:center; font:normal 13px/20px "微软雅黑"; color:#666; padding:15px 0;}
			table.tab05 tr td a{ color:#08c; margin:0 10px;}
			table.tab05 tr td a:hover{color:#e84e46;}
			table.tab05 tr td span.color3{ color:#ed4f4f;}
			
        	.grzx_top{ width:96%; height:35px; font:normal 14px/30px "微软雅黑"; color:#555; margin:0 auto; padding-top:20px; margin:0 auto; }
			.grzx_top .grzx_ss{ float:left; display:inline;}
			.grzx_top .grzx_cz{ float:right; display:inline;}
			.grzx_top .grzx_ss select{width:130px; height:32px; box-sizing:border-box; padding:6px 0; border:1px solid #e6e4e3; text-indent:10px; color:#666;   background:#fff; font:normal 12px/20px "微软雅黑"; border-radius:3px; -moz-border-radius:3px; -ms-border-radius:3px; -o-border-radius:3px; -webkit-border-radius:3px; vertical-align:middle;}
			.grzx_top .grzx_ss input.text10{width:130px; height:32px; border:1px solid #e6e4e3; text-indent:10px; color:#666;   background:#fff; font:normal 12px/27px "微软雅黑"; border-radius:3px; -moz-border-radius:3px; -ms-border-radius:3px; -o-border-radius:3px; -webkit-border-radius:3px; vertical-align:middle;}
			.grzx_top  .but15{ width:80px; height:32px; display:inline-block;  background:#fa7474; border:1px solid #ed4f4f; text-align:center; cursor:pointer; font:normal 13px/30px "微软雅黑";  color:#fff; margin-left:10px; border-radius:3px; -moz-border-radius:3px; -ms-border-radius:3px; -o-border-radius:3px; -webkit-border-radius:3px;  }
			.grzx_top  .but15:hover{ background:#ed4f4f;}
        </style>
      </head>  
      
      <body>  
      <form action="/mtest/user/showUser" method="post">
      
        <div class="grzx_top">
			
			<div class="grzx_ss"> 
				真实姓名：<input type="date"  name="realName" value="${realName}" class="text10">  <input type="submit" value="查询" class="but15"/> 
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
		                  </tr>
		
				</c:forEach>
			</tbody>
			
		</form>
			
	
      </body>  
    </html>  