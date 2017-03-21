
#set($endIndex = ($page.start)+ $page.result.size())
#set($startIndex = $page.startIndex)
	<input id="pageNumber" name="pageNumber" type="hidden" value="$page.currentPageNo" />
	<input id="isPageClick" name="isPageClick" type="hidden" value="N" />
	<input id="allPages" type="hidden"	value="$!page.totalPageCount" />

  #if($page.totalCount>0)	
    <div class="page">
    	<a href="javascript:goPage(1)">首页</a>
    	#if($page.currentPageNo >  1)
    	<a href="javascript:goPage(parseFloat($!page.currentPageNo) - 1 )" >上一页</a>
    	#end
    	#foreach($pageNumber in [$!page.startPage..$!page.endPages])
    		<a href="javascript:goPage($pageNumber)" #if($pageNumber==$page.currentPageNo)class="pageon"  #end>$pageNumber</a>
    	#end
    	#if($page.currentPageNo < $!page.totalPageCount )
    	<a href="javascript:goPage(parseFloat($page.currentPageNo) + 1 )" >下一页</a>
    	#end
    	<a href="javascript:goPage($!page.totalPageCount)" >尾页</a>
		
    	<!--<span class="tz">
			<input type="text" value="" name='searchPage' class="pagetext2">
			<input type="button" value="GO" class="pagebut" onclick='javascript:searchPageGo();'>
		</span>-->
    </div>	
  #else
	<div class="page">å±æ1é¡µ &nbsp;&nbsp;&nbsp;&nbsp;å±æ0æ¡&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
  #end	
	
	
<script type="text/javascript">
	function goPage(intPage)
	{
		var pageNumber=document.getElementById("pageNumber");
		pageNumber.value=intPage;
		pageNumber.form.submit();
	}
	var totalPage = $!page.totalPageCount;
	function searchPageGo(){
		var searchPage = $('input[name=searchPage]').val();
		## 抢先判断不大于0就为1，用于兼容数字外其他字符的情况
		if(parseFloat(searchPage) < 1 ){
			searchPage = 1;
		}
		## 大于最大page值即只能查询最大page值
		if(parseFloat(searchPage) > parseFloat(totalPage)){
			searchPage = totalPage;
		}
		var pageNumber=document.getElementById("pageNumber");
		pageNumber.value=searchPage;
		pageNumber.form.submit();
	}
</script>
	

