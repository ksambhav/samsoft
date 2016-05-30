angular
    .module('customerModule')
    .controller('EditCustomerCtrl',
        function($scope, customer, customerService) {
            console.log(customer);
            if (customer.id) {
                console.debug("Edit flow");
            } else {
                console.debug("New Customer flow.");
            }

            $scope.saveCustomer = function() {
                if ($scope.customerForm.$valid) {
                    $scope.customer = customerService.save($scope.customer);
                    console.debug($scope.customer);
                } else {
                    console.error($scope.customerForm.$error);
                }
            };
        });
