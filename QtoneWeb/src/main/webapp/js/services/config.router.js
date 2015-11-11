'use strict';

/**
 * 配置路由
 * 
 * @sherlock221b
 */
Forgroundapp.config(function($stateProvider, $urlRouterProvider, VERSION) {
	$stateProvider.state('app', {
		url : '/app',
		abstract : true,
		templateUrl : 'html/app.html?v=' + VERSION.vs
	})

	.state('app.index', {
		url : '/index',
		templateUrl : 'html/index.html?v=' + VERSION.vs,
		controller : "IndexCtrl"
	}).state('app.page1', {
		url : '/page1',
		templateUrl : 'html/page1.html?v=' + VERSION.vs,
		controller : "Page1Ctrl"
	}).state('app.page2', {
		url : '/page2',
		templateUrl : 'html/page2.html?v=' + VERSION.vs,
		controller : "Page2Ctrl"
	}).state('app.page3', {
		url : '/page3',
		templateUrl : 'html/page3.html?v=' + VERSION.vs,
		controller : "Page3Ctrl"
	}).state('app.page4', {
		url : '/page4',
		templateUrl : 'html/page4.html?v=' + VERSION.vs,
		controller : "Page4Ctrl"
	})

	// login
	$urlRouterProvider.otherwise('/app/index');

});
