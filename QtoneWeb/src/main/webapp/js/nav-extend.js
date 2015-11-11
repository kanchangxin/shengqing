/*lw*/
$(document).ready(
		
		function(){
		
			$("#search-data").mouseover(
			
				function(){
					$("#drop-menu").css("display","block");
				}
			);
			
			$("#drop-menu").mouseover(
			
				function(){
					$("#drop-menu").css("display","block");
				}
			);
			$("#drop-menu").mouseout(
			
				function(){
					$("#drop-menu").css("display","none");
				}
			);
			
			
			/*
		     *
			 *登陆注册
			 *
			 */
			 
			//背景层
			var pageHeight =1000;
			var pageWidth = $(document.body).width();
			//盒子
			var winHeight = $(window).height();
			var winWidth = $(window).width();

			$("#login-link").click(

				function(){

				$(".bg-box").css({
					"height":pageHeight,
					"width":pageWidth
					});
				var boxHeight = $(".login-box").outerHeight();
				var boxWidth = $(".login-box").outerWidth();

				var boxleft = (winWidth - boxWidth)/2 + "px";
				var boxtop = (winHeight - boxHeight)/2 + "px";

					$(".login-box").css({
						"top": "50%",
						"left": "50%",
						"margin-top": "-178px",
						"margin-left": "-250px"
					});

					$(".bg-box").css("display","block");

					$(".login-box").css("display","block");
					$(".register-box").css("display","none");
					$(".forget-box").css("display","none");
				}
			);

			$("#toLogin").click(
				
				function(){
				
				$(".bg-box").css({
					"height":pageHeight,
					"width":pageWidth
					});	
				var boxHeight = $(".login-box").outerHeight();
				var boxWidth = $(".login-box").outerWidth();
			
				var boxleft = (winWidth - boxWidth)/2 + "px";
				var boxtop = (winHeight - boxHeight)/2 + "px";
		
					$(".login-box").css({
					"left":boxleft,
					"top":boxtop
					});
					
					$(".bg-box").css("display","block");
				
					$(".login-box").css("display","block");
					$(".register-box").css("display","none");
					$(".forget-box").css("display","none");
				}
			);
			$("#toforget").click(

				function(){

					$(".bg-box").css({
						"height":pageHeight,
						"width":pageWidth
					});
					var boxHeight = $(".forget-box").outerHeight();
					var boxWidth = $(".forget-box").outerWidth();

					var boxleft = (winWidth - boxWidth)/2 + "px";
					var boxtop = (winHeight - boxHeight)/2 + "px";

					$(".forget-box").css({
						"left":boxleft,
						"top":boxtop
					});

					$(".bg-box").css("display","block");

					$(".forget-box").css("display","block");
					$(".login-box").css("display","none");
					$(".register-box").css("display","none");
				}
			);
			$("#register-link").click(
				
				function(){
					$(".bg-box").css({
					"height":pageHeight,
					"width":pageWidth
					});	
					
					var boxHeight1 = $(".register-box").outerHeight();
					var boxWidth1 = $(".register-box").outerWidth();
				
					var boxleft1 = (winWidth - boxWidth1)/2 + "px";
					var boxtop1 = (winHeight - boxHeight1)/2 + "px";

					
					$(".register-box").css({
					"left":boxleft1,
					"top":boxtop1
					});
					
					$(".bg-box").css("display","block");
					$(".login-box").css("display","none");
					$(".register-box").css("display","block");
					$(".forget-box").css("display","none");
				}
			);
			
			$("#toRegister").click(
				
				function(){
					$(".bg-box").css({
					"height":pageHeight,
					"width":pageWidth
					});	
					
					var boxHeight1 = $(".register-box").outerHeight();
					var boxWidth1 = $(".register-box").outerWidth();
				
					var boxleft1 = (winWidth - boxWidth1)/2 + "px";
					var boxtop1 = (winHeight - boxHeight1)/2 + "px";
					
					
					$(".register-box").css({
					"left":boxleft1,
					"top":boxtop1
					});
					
					$(".bg-box").css("display","block");
					$(".login-box").css("display","none");
					$(".register-box").css("display","block");
				}
			);
		
			
			$(".box-close").click(
				function(){
					$(".bg-box").css({
					"height":0,
					"width":0
					});	
					$(".bg-box").css("display","none");
					$(".login-box").css("display","none");
					$(".register-box").css("display","none");
					$(".forget-box").css("display","none");
				}
			);
		}

);

