Forgroundapp.controller("IndexCtrl", function ($rootScope, $scope,$http, Util, $state, SERVER, VERSION, $timeout) {

    $rootScope.showTop=false;
  //设置标题
    document.title="首页";

    $scope.user={
        account:"",
        password:"",
        saveme:false
    };

    var user=$rootScope.getUser();
    if(user){
        $scope.user.account=user.account;
        $scope.user.password=user.password;
        $scope.user.saveme=true;
    }


    $scope.onLogin=function(obj){

        //var data="name="+$scope.user.account+"&password="+$scope.user.password;
        var jsonObjec={
            name:$scope.user.account,
            password:$scope.user.password
        };

        //连接服务器
        var url=SERVER.testUrl.mp+"/cross/login.do";
        $http.post(url,jsonObjec)
            .success(function(result){
                alert(result.data.name);

                if($scope.user.saveme){

                    $rootScope.setUser($scope.user);
                }else{
                    $rootScope.removeUser();
                }

                $state.go("app.page1");


            })
            .error(function(err){
                alert("登录失败");
            });

    }

});