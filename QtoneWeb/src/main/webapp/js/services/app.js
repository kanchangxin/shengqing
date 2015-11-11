'use strict';

var Forgroundapp = angular.module('Forgroundapp', [
    'ui.router',
    //'ngAnimate',
    'angular-loading-bar',
    'ui.bootstrap',
    "toastr",

    'ngCookies'
    //,
    //'me-pageloading'
]);

Forgroundapp.config(function($interpolateProvider) {
    $interpolateProvider.startSymbol('[[');
    $interpolateProvider.endSymbol(']]');
});


//��ҳָ��
Forgroundapp.directive('paging', function () {
    return {
        restrict: 'E',
        template: '',
        replace: true,
        link: function (scope, element, attrs) {
            scope.pPreviousPage=function(){
                if(scope.page.hasPreviousPage){
                    scope.queryGiven(scope.page.currentPage-1);
                }
            };
            scope.pNextPage=function(){
                if(scope.page.hasNextPage){
                    scope.queryGiven(scope.page.currentPage+1);
                }
            };
            scope.pFirstPage = function () {
                scope.queryGiven(1);
            };
            scope.pLastPage = function () {
                scope.queryGiven(scope.page.totalPages);
            };
            scope.pIsActive = function (page) {
                if(scope.page){
                    return scope.page.currentPage === page;
                }
                return false;
            };
        }
    };
});

