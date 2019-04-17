var time_delay=null;
$(document).ready(function(){
		$.fn.scroll_({arrows:false,mouseWheelSpeed: 30,verticalGutter:15});
		if ($("#playBanner").length>0)
		{
				$("#playBanner").ZHYslider({
						speed: 1200, 
						space: 6000,
						auto: true, //自动滚动
						affect:'fade',
						ctag: '.Slide_'
				})
			
			
		}
		//返回顶部
		$(".btn_backtop").bind("click",function(){
			$("html,body").animate({scrollTop:0},1000)	
			return false;
		})
		$("#quickDown ul li").hover(function(){$(this).find("i").addClass("flipx")},function(){$(this).find("i").removeClass("flipx")})
		
		$("#menu li").hover_animate(
				{
				  aniobj:
				  [
					  [
						  "em",					//应用对象
						  "{'position':'relative'}",//初始CSS
						  "{'top':'8px'}",		//mouseenter动画CSS
						  "{'top':0}",			//mouseleave动画css
						  "300",					//mouseenter 时间
						  "300"						//mouseleave 时间
					  ],
					  [
						  "span",					//应用对象
						  "{'position':'relative'}",//初始CSS
						  "{'top':'25px','opacity':0}",		//mouseenter动画CSS
						  "{'top':0,'opacity':1}",			//mouseleave动画css
						  "300",					//mouseenter 时间
						  "300"						//mouseleave 时间
					  ]
				  ]
				}
				
			)		
		if ($("#ZhiYe").length>0)
		{
			
				$("#ZhiYe").ZHYslider({
						speed: 1200, 
						space: 6000,
						auto: true, //自动滚动
						affect:'scrollx',
						ctag: '.Slide_',
						End:function(self,switch_obj,settings){
							self.find(".ZhiYeTab").on("click","li",function(){
								var index=$(this).index()
								switch_obj.find(settings.stag+':eq('+index+')').trigger(settings.trigger)
							})
						},
						beforeStart:function(self,index){
							self.find(".ZhiYeTab li:eq("+index+")").addClass('change').siblings().removeClass("change")
						}
				})
				
		
		}
		
	$("#PhotoShowGundong").jcarousellite_gundong({btn:1,list:".PicList li","visible":3,"auto":2500,"speed":300,afterEnd:function(){}})		
		setTimeout(function(){
			$('#Introduction .Tab').Tab({lilab:"li",labselect:".change",Tabname:".Tab_nr",labaction:"click",animatename:"scroll_x",animateTime:600,mode:"none"})
		},130)
		//图片悬停
		$(".PicList li").bind('mouseenter',function(){
					var self=$(this)
					time_delay=setTimeout(function(){
								if(!self.is(":animated"))
								{
									self.addClass("star_animate");
									var img=self.find("img")
									
									img.stop(true,false).animate({"opacity":0.6}, 500);
									self.stop(true,false).animate({"margin-top":"-8px"}, 500);
								}
						
					},100)
				
			}).bind('mouseleave',function(){
				    clearTimeout(time_delay)	
							var self=$(this)
							if (self.is(".star_animate"))
							{		
									self.removeClass("star_animate");
									var img=self.find("img")
									img.stop(true,false).animate({"opacity":1}, 500);
									self.stop(true,false).animate({"margin-top":"0"}, 500);
							}
			})			
		
		
})

$.fn.hover_animate=function(obj){
	var time_delay=null,runlist=[],runlist_end	=[],create_var=[],set_var=[],self=$(this)
		if (self.length==0) return false;
		if (obj.aniobj.length==0) return false;
		if (obj.set_class=="" || typeof (obj.set_class)=="undefined") {$.extend(obj,{set_class:"hover"});	}
		if (typeof(obj.delaytime)!="number" || typeof(obj.delaytime)=="undefined"){$.extend(obj,{delaytime:100});	}
		var fn={
			csschange:function(val){
				if (val==""){return '';}
				if (val.indexOf("{")<0 || val.indexOf("}")<0 )
				{
					val=$.trim(val)
					var last_fh=val.lastIndexOf(';')
					if (last_fh+1==val.length)
					{
						val=val.substring(0,last_fh);
						val='{\''+val.replace(/\:/g,"':'").replace(/\;/g,"','")+'\'}';
					}
					else
					{   val='{\''+val.replace(/\:/g,"':'").replace(/\;/g,"','")+'\'}';	}
				}
				return $.trim(val);
			}	
		}
		$.each(obj.aniobj,function(index,val){
			if (val.length<6) return false;
			var setobj			=	val[0],
				setobj_			=	setobj.replace(/\.|\ |\>/g,""),
				animate_css		=	fn.csschange(val[1]),
				animate_start	=	fn.csschange(val[2]),
				animate_end		=	fn.csschange(val[3]),
				animate_easing	=	val[4],
				animate_easing2	=	val[5],
				run				=	'',
				run_end			=	''
				
				if (setobj=="") return false;
				create_var.push('var _'+setobj_+'')
				setobj=="self" ? set_var.push('_'+setobj_+'=[self]'): set_var.push('_'+setobj_+'=[self].find("'+setobj+'")')
				if (animate_css=="" && animate_start=="") return false;
				if (animate_css!="" && animate_start!="")
				{run='_'+setobj_+'.css('+animate_css+').stop(true,false).animate('+animate_start+','+animate_easing+')'}		
				else if (animate_css=="" && animate_start!="")
				{run='_'+setobj_+'.stop(true,false).animate('+animate_start+','+animate_easing+')'}
				else if (animate_css!="" && animate_start=="")
				{run='_'+setobj_+'.css('+animate_css+')'}
				
				runlist.push(run)
				if (animate_end!="")
				{	
					run_end='_'+setobj_+'.animate('+animate_end+','+animate_easing2+')'
					runlist_end.push(run_end)
				}
				
		})
		var selfobj=null;
		self.unbind(".s")
		$.each(create_var,function(index,val){eval(val);})
		self.bind("mouseenter.s",function(){
			selfobj=$(this)
			$.each(set_var,function(index,val){eval(val.replace("[self]","selfobj"));})
			clearTimeout(time_delay)	
			time_delay=setTimeout(function(){
					if(!selfobj.is(":animated"))
					{
						selfobj.addClass(obj.set_class);
						$.each(runlist,function(index,val){eval(val)})	;
					}
			},obj.delaytime)
		})
		.bind("mouseleave.s",function(){
			clearTimeout(time_delay)	
			if (selfobj.is("."+obj.set_class))
			{		
				$.each(runlist_end,function(index,val){eval(val);})	
				selfobj.removeClass(obj.set_class);
			}
		})
}
//选项卡切换
		$.fn.Tab=function(config){
			var self=$(this);
			var select_=0;
			var classname=config.labselect.replace(".","")
			if (self.length==0) return false;
			if (self.find(config.lilab).length==0) return false;
			
			
			self.each(function(index, element) {
							
				self=$(this);
						
						if (self.find(config.labselect).length==0) 
						{self.find(config.lilab+":eq(0)").addClass(classname);}
						self.find(config.lilab).each(function(index, element) {
							if (!$(this).is(config.labselect))
							{
								self.siblings(config.Tabname+":eq("+index+")").hide();
							}
						});
						
						self.find(config.lilab).bind(config.labaction+".action",function(){
							
							var index=$(this).index();
							if(self.siblings(config.Tabname+":visible").is(":animated")){ 
							return false;
							
							}

							
							if ($(this).is(config.labselect)) return false;
							var index2=$(this).siblings(config.labselect).index()
							$(this).addClass(classname).siblings().removeClass(classname);
							
							config.animate(index,index2,config.animatename)
							return config.labaction=="click"?   false :  true;
						})
						
						config.animate=function(index,index2,active){
							
							switch (active)
							{
								case "fade":
									self.siblings(config.Tabname+":visible").hide();
									self.siblings(config.Tabname+":eq("+index+")").fadeIn(config.animateTime);
								break;
								case "scroll_x":
									self.parent().css({"position":"relative","overflow":"hidden"});
									var selfs=self.siblings(config.Tabname+":visible")
									var dr="100%",dr2="100%"
									if (index2>index)
									{
										dr="100%";
										dr2="-100%"
									}
									else
									{
										dr="-100%";
										dr2="100%"
									}
									var top=selfs.position().top
									
									
									if (config.mode=="delay")		
									{
									//当前渐隐
									selfs
									.css({"position":"relative","width":"100%"})
									.stop(true,false)
									.animate({"left":dr,"opacity":0},config.animateTime,
												function(){
													 $(this).css({"position":"static","left":"auto","opacity":1,"display":"none"}
												)}
											)
									setTimeout(function(){
												self.siblings(config.Tabname+":eq("+index+")").css({"position":"relative","left":dr2,"display":"block","opacity":0})
												.stop(true,false)
												.animate({"left":0,"opacity":1},config.animateTime
												,function(){
														$(this).css({"top":0,"position":"static"})	
														
												})
									},config.animateTime)		
								
									}
									
									else
									{
										
											selfs
											.css({"position":"absolute","width":"100%","left":selfs.position().left,"top":selfs.position().top})
											.stop(true,false)
											.animate({"left":dr,"opacity":0},config.animateTime,
												function(){
													 $(this).css({"position":"relative","top":"auto","left":"auto","opacity":1,"display":"none"}
												)}
											)
									
									
												self.siblings(config.Tabname+":eq("+index+")").css({"position":"relative","left":dr2,"display":"block","opacity":0})
												.stop(true,false)
												.animate({"left":0,"opacity":1},config.animateTime
												,function(){
														$(this).css({"top":0,"position":"relative"})	
														
												})
									}
								break;
								
								
								case "none":
									self.siblings(config.Tabname+":visible").hide();
									self.siblings(config.Tabname+":eq("+index+")").show();
								break;	
								
							}
							
							
						}


            });

		}
		

//加载滚动条
$.fn.scroll_=function(config){
	var scrollobj=$("[data-scroll]")
	if (scrollobj.length==0) return false;
	scrollobj.each(function(index, element) {
			var self=$(this)
			if (self.length==0)  return false;
			
			var h=parseInt(self.attr("data-scroll-height")),
				w=parseInt(self.attr("data-scroll-width")),
				color=self.attr("data-scroll-color");
				self.css({"width":"100%"});
				self.wrap('<div class="container1" style="width:'+w+'px"></div>').wrap('<div class="div_scroll"></div>');
				self.parents('.div_scroll').css({height:h}).scroll_absolute(config)	
				self.find("img").load(function(){self.parents('.div_scroll').scroll_absolute(config);})
			
			if (typeof(color)!="undefined")
			{setTimeout(function(){self.parents(".container1").find(".scroll_drag").css({"background":color})},500);}
	});
}

//弹窗口
function show(file,width,height)
{	
	$("#window").empty().remove();
	$("body").append('<div id="window"><div id="float_window"><iframe src="'+file+'" style="width:'+width+';height:'+height+';background-color:transparent;overflow:hidden;" scrolling="no" frameborder="0" allowtransparency="true" id="popupFrame" name="popupFrame" width="100%" height="100%"></iframe><span class="closewindow"></span></div></div>')
	$("#window").css("height",$(window).height()).show()
	$("#float_window").css({"width":width,"height":height,"margin-left":"-"+parseInt(width/2)+"px","margin-top":"-"+parseInt(height/2)+"px"})
	$(".closewindow").unbind("click");
	$(".closewindow").bind("click",function(){$("#window").empty().remove();})
}

//关闭窗口
function closewindow(){$("#window").empty().remove();}					
					
//滚动
		$.fn.jcarousellite_gundong=function(options ){
			var self=$(this);
			if (self.length==0) return false;
			var items=options.list,config;
			if (self.find(items).length<=options.visible) 
			{
				var width=self.find(options.list).parent().outerWidth()
				self.css({"margin":"0 auto","width":width})
			return false;	
			}
			else
			{
				var liobj=self.find(options.list)
				var width=liobj.outerWidth()
				var margin=parseInt(liobj.css("margin-left"))+parseInt(liobj.css("margin-right"));
				width+=margin
				self.css({"margin":"0 auto","width":width*options.visible})
			}
			self.css("overflow","visible");
			
			if (self.find(items).is("div"))
			{
				self.find(items).wrap("<li></li>");
				self.find(items).parent().wrapAll("<ul class='templist'></ul>");		
				items=".templist li"
			}
			self.find(items).parent().wrapAll('<div class="jCarouselLite"></div>').parent().wrapAll('<div class="gundong"></div>');
			
			
			if (options.btn!=0)
			{
				self.find(".gundong").append('<span class="clear"></span><a href="javascript:;"  class="move_right"><span></span></a><a href="javascript:;" class="move_left disabled" ><span></span></a>')
			}
			
			self.find(".gundong").each(function(index){
				
				config={
							btnPrev: $(this).find(".move_left:eq("+index+")"),
							btnNext: $(this).find(".move_right:eq("+index+")"),
							visible:1,
							auto: 2500 ,
							speed: 300
						}	
				if (options.btn==0)		
				{
					$.extend(config, {btnPrev:null,btnNext:null});							
				}
				$.extend(config, options);
				$(this).find(".jCarouselLite:eq("+index+")").jCarouselLite(config);	
			})
		}