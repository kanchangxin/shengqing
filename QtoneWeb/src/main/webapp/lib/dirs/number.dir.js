WXapp.directive('nb', function(){
    return {
        restrict : "A",
        scope: {
            number: '@'
        },
        link: function(scope, element, attrs){

            var a_num = scope.number * 1;
            var a = 1;
            var crear_a = "";
            var change_a = function() {
                if (a <a_num) {
                    a += 4;
                    element.text(a);
                }
                else{
                    element.text(a_num);
                    clearInterval(crear_a);
                }
            }
            crear_a = setInterval(change_a, (3000 / a_num));
        }


    }})