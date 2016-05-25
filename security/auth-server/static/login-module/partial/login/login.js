angular.module('loginModule').controller('LoginCtrl', function($scope, $http) {

	$scope.login = function() {
		console.log('Sending login');
		$http.post('/uaa/login/',{username:'user',password:'password'}).then(function(success){
			console.info('success');
			console.log(success);
		},function(){
			console.error('Cant login');
		});
	};
});