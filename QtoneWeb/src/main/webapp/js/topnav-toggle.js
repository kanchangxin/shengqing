$(document).ready(function(){

	var isFirstupper_apex= $.cookie('isFirstShow_upper_apex_sx'); //控制弹出广告窗口，一天只出现一次
	if(isFirstupper_apex==1){
		$(".upper_apex").hide();
		$("body").css("padding-top","0");
		$(".ww").css("height","70px");
		$(".inner").css("margin-top","100px");
	}

});


function upclose(){
	$(".upper_apex").hide();
	$("body").css("padding-top","0");
	$(".ww").css("height","70px");
	$(".inner").css("margin-top","100px");
	$.cookie('isFirstShow_upper_apex_sx', 1 ,{ expires: 1 }); //有效期一天
}

