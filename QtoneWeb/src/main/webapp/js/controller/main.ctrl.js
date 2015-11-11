/**
 * @desc 全局ctrl
 * @auth sherlock221b
 */
Forgroundapp.controller("MainCtrl", function ($rootScope, $scope,toastr, SERVER, $location, $state, Util, VERSION) {
    SERVER.url = SERVER.login;
    //go state
    $rootScope.goState = function (name) {
        if ($rootScope.settingLayer) {
            $rootScope.settingLayer = false;
        }
        $state.go(name);
    }

    $rootScope.nav="";
    //退出
    $rootScope.loginOut=function(){
        Util.removeLg("user");
    }

    //获取用户
    $rootScope.getUser=function(){
        return Util.getLgObj("user");
    }

    //设置用户
    $rootScope.setUser=function(user){
        Util.setLgObj("user",user);
        $rootScope.user=user;
    }

    $rootScope.removeUser=function(){
        Util.removeLg("user");
    }
    //系统提示方式
    $rootScope.toastSuccess = function (content, timeOut) {
        toastr.success(content, {
            timeOut: timeOut || 2500,
            positionClass: 'toast-bottom-center'
        });
    };
    $rootScope.toastError = function (content, timeOut) {
        toastr.error(content, {
            timeOut: timeOut || 2500,
            positionClass: 'toast-bottom-center'
        });
    };
    $rootScope.toastInfo = function (content, timeOut) {
        toastr.info(content, {
            timeOut: timeOut || 2500,
            positionClass: 'toast-bottom-center'
        });
    };
});

