Forgroundapp.filter('to_trusted', ['$sce', function ($sce) {
    return function (text) {
        return $sce.trustAsHtml(text);
    }
}
]);

Forgroundapp.filter('userFilter', function () {
    return function (text) {
        if(text=="1"){
            return "家长";
        }else if(text=="2"){
            return "学生";
        }
    }
}
);
Forgroundapp.controller("Page2Ctrl", function ($rootScope, $stateParams, $scope, Util, $state, SERVER, VERSION, $timeout) {

    //设置标题
    document.title="页2";
    $rootScope.showTop = true;
    $rootScope.nav = "about";
    //console.log($stateParams.id+"  "+$stateParams.ip);

    $scope.testSrc = "<a >这是html文本<br/>这是第二行</a>";
});