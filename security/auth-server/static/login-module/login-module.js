angular.module('loginModule', ['ui.bootstrap','ui.router','ngAnimate']);

angular.module('loginModule').config(function($stateProvider) {

    $stateProvider.state('login', {
        url: '/',
        templateUrl: 'login-module/partial/login/login.html',
        controller:'LoginCtrl'
    });
    /* Add New States Above */

});

