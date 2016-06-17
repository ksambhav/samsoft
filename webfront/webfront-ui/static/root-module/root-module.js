angular.module('rootModule', ['ui.bootstrap', 'ui.router', 'ngAnimate']);

angular.module('rootModule').config(function($stateProvider) {

    $stateProvider.state('root', {
        abstract: true,
        resolve: {
            currentUser: function($http, $location) {
                return $http.get('me').then(function(success) {
                    console.debug('User Logged in');
                    return success.data;
                }, function(error) {
                    console.warn('user not logged in. Should redirect to login page.');
                    return null;
                });
            }
        },
        controller: function($scope, currentUser, $http) {
            console.debug('root controller');
            console.debug(currentUser);
            $scope.modelOptions = {
                debounce: {
                    default: 2000,
                    blur: 2000
                },
                getterSetter: true
            };
            $scope.searchCustomer = function(val) {

                return $http.get('http://localhost:9001/customer/search', {
                    params: {
                        name: val
                    }
                }).then(function(response) {
                    console.log(response);
                    return response.data;
                });
            };
        },
        templateUrl: 'root-module/layout.html',
    });

    /* Add New States Above */

});
