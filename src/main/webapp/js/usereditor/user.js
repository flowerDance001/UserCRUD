$(document).ready(function(){

	
	  
	  
	$('.tj').click(function(){
		
		$(".black").show();
		$("#addAndE").show();
	});
	
	//点击保存
	$('.save').click(function(){
		var userId = $('input[name=userId]').val();
		var userName = $('input[name=userName]');
	    var telNo = $('input[name=telNo]');
	    var emailNo = $('input[name=emailNo]');
	    var realName = $('input[name=realNameT]');
	    var idCard = $('input[name=idCard]');
	    
	  //用户名验证
	        if (userName.val()!='') {
	        	var userId = $('input[name=userId]').val();
	        	if (userId=="") {
	        		var data = {
	        			userName:userName.val()
	        			};
		        	$.ajax({
					    url:'/mtest/user/getUserByUserName',
						data:data,
						dataType : "json",
						type: "post",
						success:function(res){
						    if(res.code == 1) {
						    	var span = userName.next('span');
								span.html("该用户已经存在！");
								span.show();
								return;
							}
						}
					});	
	        	}
		        	var span = userName.next('span');
					span.hide();
	        }else{
	        	var span = userName.next('span');
				span.html("请输入用户名");
				span.show();
				return;
	         }
		
		//姓名验证
				if ($.trim(realName.val())!='') {
					var span = realName.next('span');
					span.hide();
				}else {
					var span = realName.next('span');
					span.html("请输名字");
					span.show();
					return;
				}
				
				var reg = /^[A-Za-z\u4e00-\u9fa5]*$/;
				if (realName.val()!='') {
			        if (reg.test(realName.val())) {
			        	var span = realName.next('span');
						span.hide();
			        }else{
			        	var span = realName.next('span');
						span.html("请输入正确名字");
						span.show();
						return;
			         }
				}
		//手机验证
	        var reg = /^1[34578]\d{9}$/;
	        if (telNo.val()!='') {
		        if (reg.test(telNo.val())) {
		        	var span = telNo.next('span');
					span.hide();
		        }else{
		        	var span = telNo.next('span');
					span.html("请输入正确电话");
					span.show();
					return;
		         }
	        }else{
	        	var span = telNo.next('span');
				span.html("请输入电话");
				span.show();
				return;
	        }
		
		//身份证验证
	        var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
	        if (idCard.val()!='') {
		        if (reg.test(idCard.val())) {
		        	var span = idCard.next('span');
					span.hide();
		        }else{
		        	var span = idCard.next('span');
					span.html("请输入正确身份证号");
					span.show();
					return;
		         }
	        }else{
	        	var span = idCard.next('span');
				span.html("请输入身份证号");
				span.show();
				return;
	        }
		
		//邮箱验证
	        var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	        if (emailNo.val()!='') {
		        if (reg.test(emailNo.val())) {
		        	var span = emailNo.next('span');
					span.hide();
		        }else{
		        	var span = emailNo.next('span');
					span.html("请输入正确邮箱");
					span.show();
					return;
		         }
	        }else{
	        	var span = emailNo.next('span');
				span.html("请输入邮箱");
				span.show();
				return;
	        }
	    
	        
	        var data = {
					userId:userId,
					userName:userName.val(),
					telNo:telNo.val(),
					emailNo:emailNo.val(),
					realName:realName.val(),
					idCard:idCard.val()
			};

			$.ajax({
			    url:'/mtest/user/saveUser',
				data:data,
				dataType : "json",
				type: "post",
				success:function(res){
				    if(res.code == 1) {
				    	alert(res.msg);
				    	clean();
				    	location.reload();
					} else {
						alert(res.msg);
					}
				}
			});	
	    
	});
	
	
	
	//点击编辑
	$('.bj').click(function(){
		
		var userIdS = $(this).attr("userId");
		var userNameS = $(this).attr("userName");
		var telNoS = $(this).attr("telNo");
		var  emailNoS = $(this).attr("emailNo");
		var realNameS = $(this).attr("realName");
		var idCardS = $(this).attr("idCard");
		
		
		$('input[name=userId]').val(userIdS);
		$('input[name=userName]').val(userNameS);
	    $('input[name=telNo]').val(telNoS);
	    $('input[name=emailNo]').val(emailNoS);
	    $('input[name=realNameT]').val(realNameS);
	    $('input[name=idCard]').val(idCardS);
		
	    $(".black").show();
		$("#addAndE").show();
	    
	});
	
	//用户名验证（失去焦点）
	$('input[name=userName]').blur(function () {
        var userName = $(this);
        if (userName.val()!='') {
        	var userId = $('input[name=userId]').val();
        	if (userId=="") {
        		var data = {
        			userName:userName.val()
        			};
	        	$.ajax({
				    url:'/mtest/user/getUserByUserName',
					data:data,
					dataType : "json",
					type: "post",
					success:function(res){
					    if(res.code == 1) {
					    	var span = userName.next('span');
							span.html("该用户已经存在！");
							span.show();
							return;
						}
					}
				});	
        	}
	        	var span = userName.next('span');
				span.hide();
        }else{
        	var span = userName.next('span');
			span.html("请输入用户名");
			span.show();
			return;
         }
    });
	
	//姓名验证（失去焦点）
	$('input[name=realNameT]').blur(function(){
		var realName = $(this);
			if ($.trim(realName.val())!='') {
				var span = realName.next('span');
				span.hide();
			}else {
				var span = realName.next('span');
				span.html("请输名字");
				span.show();
				return;
			}
			
			var reg = /^[A-Za-z\u4e00-\u9fa5]*$/;
			if (realName.val()!='') {
		        if (reg.test(realName.val())) {
		        	var span = realName.next('span');
					span.hide();
		        }else{
		        	var span = realName.next('span');
					span.html("请输入正确名字");
					span.show();
					return;
		         }
			}
	});
	//手机验证（失去焦点）
	$('input[name=telNo]').blur(function () {
        var telNo = $(this);
        var reg = /^1[34578]\d{9}$/;
        if (telNo.val()!='') {
	        if (reg.test(telNo.val())) {
	        	var span = telNo.next('span');
				span.hide();
	        }else{
	        	var span = telNo.next('span');
				span.html("请输入正确电话");
				span.show();
				return;
	         }
        }else{
        	var span = telNo.next('span');
			span.html("请输入电话");
			span.show();
			return;
        }
    });
	
	//身份证验证（失去焦点）
	$('input[name=idCard]').blur(function () {
        var idCard = $(this);
        var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/; 
        if (idCard.val()!='') {
	        if (reg.test(idCard.val())) {
	        	var span = idCard.next('span');
				span.hide();
	        }else{
	        	var span = idCard.next('span');
				span.html("请输入正确身份证号");
				span.show();
				return;
	         }
        }else{
        	var span = idCard.next('span');
			span.html("请输入身份证号");
			span.show();
			return;
        }
    });
	
	//邮箱验证（失去焦点）
	$('input[name=emailNo]').blur(function () {
        var emailNo = $(this);
        var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
        if (emailNo.val()!='') {
	        if (reg.test(emailNo.val())) {
	        	var span = emailNo.next('span');
				span.hide();
	        }else{
	        	var span = emailNo.next('span');
				span.html("请输入正确邮箱");
				span.show();
				return;
	         }
        }else{
        	var span = emailNo.next('span');
			span.html("请输入邮箱");
			span.show();
			return;
        }
    });
	
	//点击取消
	$('.qx').click(function(){
		clean();
	});
	
	//清楚所有文本框和隐藏
	function clean(){
		$(".black").hide();
		$("#addAndE").hide();

	    $('input[name=userName]').val('');
	    $('input[name=telNo]').val('');
	    $('input[name=emailNo]').val('');
	    $('input[name=realNameT]').val('');
	    $('input[name=idCard]').val('');
	    $('input[name=userId]').val('');
	}
	
	
}); 