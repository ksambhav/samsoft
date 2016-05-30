angular.module('customerModule').factory('customerService',
    function() {

        return {
            find: function(id) {
                console.debug("Getting customer with id " + id);
                return { fullName: "Kumar Sambhav" };
            },
            save: function(customer) {
                console.debug('Saving Customer details');
                customer.id = 10;
                return customer;
            },
            update: function(customer) {
                console.debug("Updating customer details.");
            }
        };
    });
