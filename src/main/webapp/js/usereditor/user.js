$(document).ready(function(){
	/**��ҳ*/
	 function goPage(intPage)
 	{
 		var pageNumber=document.getElementById("pageNumber");
 		pageNumber.value=intPage;
 		pageNumber.form.submit();
 	}
	
	
	
	$('.tj').click(function(){
		
		$(".black").show();
		$("#addAndE").show();
	});
	
	
	$('.qx').click(function(){
		alert(0);
		$(".black").hide();
		$("#addAndE").hide();
	});
	
	
}); 