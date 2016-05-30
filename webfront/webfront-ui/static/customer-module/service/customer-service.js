angular.module('customerModule').factory('customerService',
    function() {

        return {
            find: function(id) {
                console.debug("Getting customer with id " + id);
                return { name: "Kumar Sambhav" };
            }
        };
    });
