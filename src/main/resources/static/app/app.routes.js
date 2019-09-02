
module.config(['$routeProvider', function($routeProvider){
	  $routeProvider
	   .when('/', {
	    templateUrl: 'views/app.view.html',
	    controller: 'appCtrl',
	    resolve: {
	      // I will cause a 1 second delay
	      delay: function($q, $timeout) {
	        var delay = $q.defer();
	        $timeout(delay.resolve, 1000);
	        return delay.promise;
	      }
	    }
	   });

}]);
