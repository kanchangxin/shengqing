/**
 * Micro 配置
 */

//常量配置
Forgroundapp.constant("VERSION",{
    vs : "1"
});


Forgroundapp.constant("SERVER", {
    url : {
        index:"",
        file : "",
        mp  : "",
        auther : "",
        micro : "",
        url:"http://127.0.0.1"
    },
    //测试
    testUrl : {
        //mp  : "http://etgyd.tunnel.mobi",//线上环境
        //mp  : "http://zgkser.zhigaokao.cn",//正式环境
        mp  : "http://127.0.0.1:8089",//测试环境
        //mp  : "http://192.168.0.24",//测试环境
        //文件上传
        file : "http://10.10.68.11:8808/file/",
        //file : "http://10.10.68.11:10000/file",
        //微官网地址
        micro : "http://10.10.68.11/MicroWebsite/start.html",
        editor : "http://123.59.108.126:3001/cmw/upload/file/editor",
        auther : "/auther/toAutherPage",
        mcurl:"http://official.weixiao100.cn"
        //micro : "http://172.16.130.17:7160/MicroWebsite/start.html"
    },

    //预发布
    formalUrl : {
        mp  : "http://imteachers.cn",
        file : "http://imzhiliao.com:10000/file",
        auther : "/auther/toAutherPage",
        //微官网地址
        micro : "http://imzhiliao.com/node-sev/MicroWebsite/start.html"
    }
});

//配置http 拦截器
Forgroundapp.config(function($httpProvider){
    //$httpProvider.defaults.withCredentials = true;
    $httpProvider.interceptors.push("AjaxInterceptors");
});


Forgroundapp.config(['cfpLoadingBarProvider', function(cfpLoadingBarProvider) {
    cfpLoadingBarProvider.includeSpinner = true;
}])

//启动项
Forgroundapp.run(function($rootScope,VERSION){
    $rootScope.VERSION = VERSION;
});
