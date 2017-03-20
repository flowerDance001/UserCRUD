/**
 * @fileoverview tab组件，支持click, hover事件
 * @author yangle | yorsal.coms
 * @created  2012-05-09
 * @updated  2012-05-09
 */


define(function(require, exports, module) {
  require('../comp/plugin.js');
  var Site = {
		hover: function(obj){
				obj.hover(function(){
					$(this).addClass('hover')
				}, function(){
					$(this).removeClass('hover')
				})
		},
		
		/* select search */
		select_search: function(obj, form_obj){
			if (obj.length > 0){
				obj.each(function(){
					$(this).live('click', function(){
						form_obj.submit();
					})
					
				})

				
			}
			
		},

		init: function(){

			var $menu = $('.main-menu > ul > li'),
				$customForm = $('.jqtransform'),
				$button = $('button.button');
			if ($menu.length > 0){
				Site.hover($menu);
			}
			if ($button.length > 0){
				Site.hover($button);
			}
			if ($customForm.length > 0){
				$customForm.jqTransform();
			}
			
			var dateInputs = $('input[type=date]');
			if(dateInputs.length) {
				dateInputs.each(function(i,item){
					var dateconfig = {trigger:true, selectors:true};
					dateconfig.trigger = undefined;
					dateconfig.yearRange = [-10,15];
					if($(item).attr('yearRange')) {
						dateconfig.yearRange = eval($(item).attr('yearRange')) || [-10,15];
					}
				    $(item).dateinput(dateconfig);
				});
			    //dateInputs.dateinput({trigger: true, selectors:true, yearRange: [-10, 15]});
			}
			
			/* 只能输入数字 */
			var maskMoney = $('.mask_money');
			
			maskMoney.css('ime-mode','disabled');
			maskMoney.bind("copy cut paste", function (e) { // 通过空格连续添加复制、剪切、粘贴事件 
				e.preventDefault(); // 阻止事件的默认行为 
				}); 
			
			if (maskMoney.length > 0){
				maskMoney.keypress(function(event){
					var keyCode = event.which, value = $(this).val();
					if (keyCode === 0 || keyCode === 46 || keyCode === 8 || (keyCode >= 48 && keyCode <= 57)){
						if (value.indexOf('.') !== -1){
							if (keyCode === 46){
								return false;
							}
							var _this=this;
							var getCurserIndex = function(){
					            var oTxt1 = _this;
					            var cursurPosition=-1;
					            if(oTxt1.selectionStart){//非IE浏览器
					                cursurPosition= oTxt1.selectionStart;
					            }else{//IE
					            	if(document.selection) {
					                    var range = document.selection.createRange();
					                } else {
					                	return -1;
					                }
					                range.moveStart("character",-oTxt1.value.length);
					                cursurPosition=range.text.length;
					            }
					            return cursurPosition;
					        }
							var cursorIndex = getCurserIndex();
							var content;
							if(document.all)
						    {
								if(document.selection) {
								    content = document.selection.createRange();
			                    } else {
			                    	content = {};
			                    }
						    }
							else
							{
							    content = window.getSelection();
							    content.text = content.toString();
							} 
							var selectStr = content.text;
							if (value.substring(value.indexOf('.') + 1).length > 1 && keyCode !== 8 && cursorIndex>value.indexOf('.') && keyCode!==0 && !selectStr.length){
								return false;
								
							}
						}
						return true;
					}
					else {
						return false;
					}	
				}).focus(function(){
					this.style.imeMode = 'disabled';
				});
			}
			
			
			
			if ($(".ul-show").length > 0){
				$(".ul-show").hover(function(){
					$('a', this).addClass("cur");
					$('ul', this).show();
				}, function(){
					$('a', this).removeClass("cur");
					$('ul', this).hide();
				});
				
			}

			if ($('#more-h').length > 0){
				$('#more-h').click(function(){
					$('#more-layer').slideToggle("");
				});
			}
			if ($('#inq').length > 0){
				$('#inq').click(function(){
					$('#inq-layer').toggle();
					if($('#inq').attr('class')=='more-s'){
						$('#inq').attr('class','more-i');
						}
					else{
						$('#inq').attr('class','more-s');
						}
				});

			}
				

			$.fn.extend({
				disable: function(){
					this.attr('disabled',true).addClass('disabled');
				}
			});
			
			$('input').each(function(){
				if($(this).attr('disabled') || $(this).attr('readonly')) {
					$(this).addClass('disabled');
				}
			});
			
		}
	};
	
	Site.init();
	
	return Site;
	
  
  
});