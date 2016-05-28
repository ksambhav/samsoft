angular.module('homeModule', [ 'rootModule']);

angular.module('homeModule').config(function($stateProvider) {

    $stateProvider.state('dashboard', {
    	parent : 'root',
        url: '/home',
        resolve : {
			principal : function(currentUser){
				return currentUser;
			}
		},
		views : {
			'mainContent' : {
				 templateUrl: 'home-module/partial/dashboard/dashboard.html',
				controller:'DashboardCtrl'
			}
		}
       
    });
    /* Add New States Above */

});

