$(function(){
	
	
	require('../comp/init.js');
	require('../plugins/jquery.window.js');
	require('../plugins/jquery.jqtransform.js')($); 
    require('../plugins/jquery.form.js')($); //jquery ajax form���
	
    
    alert(0);
    
    $('.tp').click(function(){
		var userId = $('input[name=userId]').val();
		if ($.trim(userId)==''){
			window.location.href="/login.htm";
			return;
		}
		var  byUserId = $(this).attr("byUserId");
		var  byUserName = $(this).attr("byUserName");
		var data = {
			byUserId:byUserId,
			byUserName:byUserName
		};
    	$.ajax({
			type : "POST",
			url : "/housePrototype/vote.htm?data="+new Date(),
			data:data,
			dataType : "json",
			success:function(res){
			
				if(res.code == '1') {
					alert(res.msg);
			    	location.reload() ;
					
			    }else{
					alert(res.msg);
			    	location.reload() ;
			    }
			}
		});
    });
    
    $('.goAgency').click(function(){
    	jQuery.ajax({
			type : "POST",
			url : "/hm/userLoginDone.htm?data="+new Date(),
			data:{},
			dataType : "json",
			success:function(res){
			
				if(res.code == '1') {
//					var userInfo = res.userInfo;
//					if(userInfo.userType != 3){
//						alert("��ǰ��½�û����Ǿ������˺ţ����л��������˺����µ�¼��");
//					}else{
//						window.location.href="/housePrototype/addHousePrototype.htm";
//					}
					window.location.href="/agency/agencyListPage.htm";
			    }else{
			    	window.location.href="/login.htm";
			    	//alert(res.msg);
			    }
			}
		});
    });

    $('.commonSearch').click(function(){
    	$(this).parent().find("a").removeClass("searchon");
    	$(this).addClass("searchon");
    	var queryType =$(this).attr("queryType");
    	$('#queryInfoListFrom').find("input[name='queryType']").val(queryType);
    	var houseType =$(this).attr("houseType");
    	$('#queryInfoListFrom').find("input[name='houseType']").val(houseType);
    });
	
    $(".searchSumbit").click(function(){
    	var keyWords=$('#queryInfoListFrom').find("input[name='keyWords']").val();
    	if(keyWords==""){
    		alert("������¥�����ơ���ַ���ⷿ��ʽ�ȹؼ���Ϣ����������");
    	}else{
    		$("#queryInfoListFrom").submit();
    	}
    	
    });

});