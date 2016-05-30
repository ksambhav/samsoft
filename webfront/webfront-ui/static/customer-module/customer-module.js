angular.module('customerModule', ['ui.bootstrap', 'ui.router', 'ngAnimate']);

angular.module('customerModule').config(function($stateProvider) {

    $stateProvider.state('edit-customer', {
        parent: 'root',
        url: '/customer/:id',
        params: {
            id: null
        },
        resolve: {
            customer: function(currentUser, $stateParams, customerService) {
                if (!$stateParams.id) {
                    return {};
                } else {
                    return customerService.find($stateParams.id);
                }
            }
        },
        views: {
            'mainContent': {
                templateUrl: 'customer-module/partial/edit-customer/edit-customer.html',
                controller: 'EditCustomerCtrl'
            }
        }

    });
    /* Add New States Above */

});
