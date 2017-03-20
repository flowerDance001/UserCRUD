
define(function(){
	$.fn.imgplayer = function(opintion){
	    var opts = $.extend({},opintion || {}); 
		opts.renderTo = this;
		var obj = new $.imgplayer(opts);
		obj.show();
		return obj;
	}
    function imgplayer(opintion){
	    var opts = $.extend({},opintion);
	    this.base.call(this,opts);
	}
	$.imgplayer = imgplayer;
	$.extend(imgplayer.prototype,$.box.prototype,{
	    base: $.box,
	    init: function(){
		    var _this = this;
			var cfg = this.opts; 		
			var img = $("<img>").attr({
			    src: $(cfg.ele).attr('src')
			});
			this.realWidth = img.width();
			this.realHeight = img.height();
			img.mousedown(function(e){
				e.preventDefault();
				this.downSts=true;
				img.css({
					cursor:'crosshair'
				});
				e = e || event;
				this.lastX = e.pageX;
				this.lastY = e.pageY;
				_this.stopPropagation(e);
			});
			img.mouseup(function(){
				this.downSts=false;
				img.css({
					cursor:'pointer'
				});
			});
			$(document).mouseup(function(){
				img[0].downSts=false;
				img.css({
					cursor:'pointer'
				});
			});
			var parent;
			img.mousemove(function(e){
				e.preventDefault();
				prevBtn.removeClass('prev-photo-hover');
				nextBtn.removeClass('next-photo-hover');
				_this.stopPropagation(e);
				if(!this.downSts)return;
				e = e || event;
				var x = e.pageX - this.lastX;
				var y = e.pageY - this.lastY;
				this.lastX = e.pageX;
				this.lastY = e.pageY;
				parent = img.parent().parent();
				parent.css({
					left: parseInt(parent.css('left')) + x,
					top: parseInt($(parent).css('top')) + y
				});
			});
			var cwBtn, acwBtn, biggerBtn, smallerBtn ,prevBtn ,nextBtn, fullBtn;
			if(cfg.index == undefined){
				for(var i = 0 ; i < cfg.eleArr.length ; i++){
					if(cfg.eleArr[i] == ele){
						cfg.index = i;
					}
				}
			}
			cfg.index = cfg.index || 0;
			if(cfg.cwBtn) {
			    cwBtn = $(cfg.cwBtn);
				cwBtn.click(function(e){
				    var degree = img.data('degree') || 0;
					if(degree == 360) degree = 0;
					var newDegreee = degree + 90;
					_this.transform(newDegreee);
					_this.stopPropagation(e);
				});
			}
			if(cfg.acwBtn) {
			    acwBtn = $(cfg.acwBtn);
				acwBtn.click(function(e){
				    var degree = img.data('degree') || 360;
					if(degree == 0) degree = 360;
					var newDegreee = degree - 90;
					_this.transform(newDegreee);
					_this.stopPropagation(e);
				});
			}
			if(cfg.biggerBtn) {
			    biggerBtn = $(cfg.biggerBtn);
				biggerBtn.click(function(e){
				    var scale = img.data('scale') || 1;
				    _this.stopPropagation(e);
				    if(scale >= 2) return;
					var newScale = scale + 0.1;
					_this.zoom(newScale,-0.1);
					_this.stopPropagation(e);
				});
			}
			if(cfg.smallerBtn) {
			    smallerBtn = $(cfg.smallerBtn);
				smallerBtn.click(function(e){
				    var scale = img.data('scale') || 1;
				    _this.stopPropagation(e);
					if(scale <= 1) return ;
					var newScale = scale - 0.1;
					_this.zoom(newScale,0.1);
				});
			}
			if(cfg.fullBtn) {
			    fullBtn = $(cfg.fullBtn);
				fullBtn.attr('title','全屏');
				fullBtn.click(function(e){
					var _parent = cfg.fullEle || $(this).parent().parent();
					if(!this.fullType)this.fullType = "+";
					if(this.fullType == "+"){
						this.defaultWidth = _parent[0].clientWidth;
						this.defaultHeight = _parent[0].clientHeight;
						_parent.width(document.documentElement.clientWidth-20);
						_parent.height(document.documentElement.clientHeight-20);
						this.fullType = "-";
						$(this).attr('title','取消全屏');
						_this.toMoveCenter(1);
					}else{
						this.fullType = "+";
						_parent.width(this.defaultWidth);
						_parent.height(this.defaultHeight);
						$(this).attr('title','全屏');
						_this.toMoveCenter(0,_parent);
					}
					_this.stopPropagation(e);
				});
			}
			if(cfg.eleArr && cfg.eleArr.length>1){
				if(cfg.prevBtn) {
					prevBtn = cfg.prevBtn = $(cfg.prevBtn);
					prevBtn.click(function(e){
						cfg.index--;
						if(cfg.index < 0){
							cfg.index = cfg.eleArr.length - 1;
						}
						var ele = cfg.eleArr[cfg.index];
						img.attr({
							src: $(ele).attr('src')
						});
						_this.realWidth = img.width();
						_this.realHeight = img.height();
						_this.loadHandler();
						_this.stopPropagation(e);
					});
				}
				if(cfg.nextBtn) {
					nextBtn = cfg.nextBtn = $(cfg.nextBtn);
					nextBtn.click(function(e){
						cfg.index++;
						if(cfg.index == cfg.eleArr.length){
							cfg.index = 0;
						}
						var ele = cfg.eleArr[cfg.index];
						img.attr({
							src: $(ele).attr('src')
						});
						_this.realWidth = img.width();
						_this.realHeight = img.height();
						_this.loadHandler();
						_this.stopPropagation(e);
					});
				}
			}
			if(cfg.mainDiv){
				if(cfg.wheelSts){
					function get(e){
						e = e || event;
						var wheelDelta = e.wheelDelta || e.detail;
						if(Math.abs(wheelDelta) >= 120){
							if(wheelDelta > 0){
								biggerBtn.click();
							}else{
								smallerBtn.click();
							}
						}else{//firefox
							if(wheelDelta < 0){
								biggerBtn.click();
							}else{
								smallerBtn.click();
							}
						}
						if(e.stopPropagation) {
				            e.stopPropagation();
				        } else {
				            e.cancelBubble = true;
				        }

				        if (e.preventDefault) {
				            e.preventDefault();
				        } else {
				            e.returnValue = false;
				        }
					}
					var wheelType = navigator.userAgent.indexOf("Firefox") > 0 ? 'DOMMouseScroll' : 'mousewheel';
					var eventEle = $(cfg.mainDiv)[0];
					if(document.addEventListener){
						eventEle.addEventListener(wheelType,function(e){
							get(e); 
						});
					}else{
						eventEle.attachEvent('onmousewheel',function(e){
							get(e); 
						});
					}
				}
				if(cfg.moveCutSts){
					$(cfg.mainDiv).bind('mousemove',function(e){
						e.preventDefault();
						if(!this.overClickSts)return;
						e = e || event;
						var x = e.pageX;
						var left = $(this).offset().left;
						var width = $(this).width();
						if(x - left > width / 2){
							this.clickType = 'next';
							nextBtn.addClass('next-photo-hover');
							prevBtn.removeClass('prev-photo-hover');
						}else{
							this.clickType = 'prev';
							prevBtn.addClass('prev-photo-hover');
							nextBtn.removeClass('next-photo-hover');
						}
					});
					$(cfg.mainDiv).bind('click',function(e){
						e.preventDefault();
						if(!this.overClickSts)return;
						e = e || event;
						if(this.clickType == 'next'){
							nextBtn.click();
						}else{
							prevBtn.click();
						}
						e.preventDefault();
						this.overClickSts = true;
					});
					$(cfg.mainDiv).bind('mousedown',function(e){
						e.preventDefault();
					});
					$(cfg.mainDiv).bind('mouseover',function(e){
						this.overClickSts = true;
					});
					$(cfg.mainDiv).bind('mouseout',function(e){
						this.overClickSts = false;
						prevBtn.removeClass('prev-photo-hover');
						nextBtn.removeClass('next-photo-hover');
					});
				}
			}
			cfg.content = img;
			cfg.container = "";
			this.base.prototype.init.call(this);
			this.loadHandler();
		},
		stopPropagation:function(e){
			var cfg=this.opts;
			if(cfg.mainDiv){
				$(cfg.mainDiv)[0].overClickSts=false;
			}
			e = e || event;
			e.stopPropagation();
		},
		setEle:function(_this){
			var cfg=this.opts;
			if(_this == "+"){
				cfg.nextBtn.click();
			}else if(_this == '-'){
				cfg.prevBtn.click();
			}else{
				var img = this.item;
				for(var i = 0 ; i < cfg.eleArr.length ; i++){
					if(cfg.eleArr[i] == _this){
						cfg.index = i;
					}
				}
				img.attr({
					src: $(_this).attr('src')
				});
				this.loadHandler();
			}
		},
		loadHandler:function(){
			var img = this.item;
			img.parent().width(img.width());
			img.parent().parent().width(img.width());
			this.zoom(0);
			this.transform(0);
			this.showInfo();
		},
		showInfo:function(){
			var cfg=this.opts;
			var ele = cfg.eleArr[cfg.index];
			if(cfg.infoEle){
				$(cfg.infoEle).html($(ele).attr(cfg.infoAttr || 'title'));
			}
			if(cfg.pathEle){
				if(typeof cfg.pathInfo == 'function'){
					$(cfg.pathEle).html(cfg.pathInfo.call(ele));
				}else{
					$(cfg.pathEle).html($(ele).attr(cfg.pathInfo || 'title'));
				}
			}
		},
		transform: function(degree){
		    var img = this.item;
            var dict = {'90': 'transform90', '180': 'transform180', '270': 'transform270'};
	        var cls = dict[degree];
	        img.removeClass(dict[90]).removeClass(dict[180]).removeClass(dict[270]);
	        if(cls) img.addClass(cls);
			img.data('degree',degree);
			var _this=this;
			setTimeout(function(){
				_this.toMoveCenter();
			},10);
			
        },
		zoom: function(scale,s,sts){
		    var w,h;
			var img = this.item;
			var _this=this;
			if(!scale){
				img.removeAttr('width').removeAttr('height');
				img.data('scale',1);
				setTimeout(function(){
					_this.toMoveCenter();
				},10);
				return;
			}
		    w = img.width()*scale/(scale+s);
			h = img.height()*scale/(scale+s);
			var parent = img.parent().parent();
			parent.css({
				left:parseInt(parent.css('left'))-(w-img.width())/2,
				top:parseInt(parent.css('top'))-(h-img.height())/2
			});
			img.attr({
			   width:w,height:h
			});
			img.data('scale',scale);
		},
		toMoveCenter:function(sts,ele){
			var img = this.item;
			var parent = img.parent().parent();
			var top = parent.parent();
			var width = $(img).width();
			var height = $(img).height();
			var pw = top.width();
			var ph = top.height();
			parent.css({
				position: 'relative',
				left: (pw-width)/2,
				top: (ph-height)/2 	
			});
			if(this.opts.showAfter)this.opts.showAfter(sts,ele);
		}
	});
});