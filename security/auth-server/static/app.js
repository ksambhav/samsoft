angular.module('samsoft.auth', ['ui.bootstrap', 'ui.router', 'ngAnimate', 'loginModule']);

angular.module('samsoft.auth').config(function($stateProvider, $urlRouterProvider,$httpProvider) {

    /* Add New States Above */
    $urlRouterProvider.otherwise('/');
    
 // To distinguish ajax call with normal http calls.
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

});

angular.module('samsoft.auth').run(function($rootScope) {

    $rootScope.safeApply = function(fn) {
        var phase = $rootScope.$$phase;
        if (phase === '$apply' || phase === '$digest') {
            if (fn && (typeof(fn) === 'function')) {
                fn();
            }
        } else {
            this.$apply(fn);
        }
    };

});
