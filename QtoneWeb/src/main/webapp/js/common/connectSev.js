
Forgroundapp.service("ConnectSev",function($http,$q,SERVER,$cookieStore){
    var info={
        /**
         * 连接到服务器
         */
        connectService:function(url,data,target){
            //console.log(angular.isElement (target));
            if(!angular.isElement (target)){
                target=target.currentTarget;
            }
            var canShow=false;
            if(typeof target != 'undefined'&&target!=""){
                canShow=true;
                tinyLoading.show( $(target) );
            }
            var defer= $q.defer();

            //+"?debug=true"
            url=SERVER.url.mp+url;

            //console.log(data);
            $http.post(url,data)
                .success(function(result){
                    if(canShow)
                        tinyLoading.hide( $(target) );
                    defer.resolve(result);


                    console.log("successUrl:["+url+"]"+" returnData："+JSON.stringify(result));
                    console.log("sendData: "+JSON.stringify(data));
                })
                .error(function(err){
                    if(canShow)
                        tinyLoading.hide( $(target) );

                    defer.reject(err);
                    console.log("errorUrl:["+url+"]"+JSON.stringify(err));
                    console.log("sendData: "+JSON.stringify(data));
                });


            return defer.promise;
        }
    };


    return info;
});
var loadingImageSrc="../images/tiny-loading.gif";
		window.tinyLoading = {

			    show: function( target ) {
			    	if (typeof(loadingImageSrc)=='undefined'){
			    		loadingImageSrc="";
			    	}

			        var loadingEl = $( '<div class="tiny-loading"><img class="img-load" alt="Loading..." src="'+loadingImageSrc+'"/></div>' );

			        loadingEl.css({
			            display: target.css( "display" ),
			            "text-align":"center",
			            "float": target.css( "float" ),
			            position: target.css( "position" ),
			            top: target.css( "top" ),
			            left: target.css( "left" ),
			            width: target.outerWidth(),
			            height: target.outerHeight(),
			            "line-height": target.outerHeight() + "px"
			        }).insertBefore( target );

			        target.hide()
			            .data( "loadingEl", loadingEl );
			    },
			    hide: function( target ) {
                    try{
                        target.show()
                            .data( "loadingEl" )
                            .remove();
                    }catch(e){
                            console.log(e);

                    }



			    }
			};