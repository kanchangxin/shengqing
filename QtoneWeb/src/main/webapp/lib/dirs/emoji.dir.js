MPreschool.directive("emoji", function ($http,Util) {
    return {
        restrict: "E",
        templateUrl: "tpl/dir/emoji.html",
        transclude: true,
        scope: {
            emoji : "="

        },
        controller: function($scope, $element, $attrs, $transclude) {
            $http({
                method:'GET',
                url:'data/function/replay/emoji.json'
            }).success(function(data,status,headers,config){
                $scope.values=data;
            }).error(function(data,status,headers,config){
                console.log('error');
            });
        },
        link: function (scope, element, attrs) {
            console.log("userCard");
            var  emoji = scope.$watch("emoji",function(newVal,oldVal,scope){
                if(newVal){
                    element.show();
                    console.log(newVal);
                    //update(newVal);
                }
            });


            //¸üÐÂÄÚÈÝ
            var update = function(){


            }

        }
    }
});
MPreschool.filter("emojiInput",function(){
    return function(){

    }

});
MPreschool.filter("emojiOutput",function(){
    return function(){
    }

});

