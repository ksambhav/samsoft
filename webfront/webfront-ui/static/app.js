angular.module('webfront', [
    'ui.bootstrap',
    'ui.router',
    'ngAnimate',
    'homeModule',
    'rootModule',
    'customerModule'
]);

angular.module('webfront').config(function ($stateProvider, $urlRouterProvider) {

    /* Add New States Above */
    $urlRouterProvider.otherwise('/home');

});

angular.module('webfront').run(function ($rootScope) {

    $rootScope.safeApply = function (fn) {
        var phase = $rootScope.$$phase;
        if (phase === '$apply' || phase === '$digest') {
            if (fn && (typeof (fn) === 'function')) {
                fn();
            }
        } else {
            this.$apply(fn);
        }
    };

});
