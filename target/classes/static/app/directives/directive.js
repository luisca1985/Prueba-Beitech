// La directiva de AngularJS permite crear los campos de fecha.
module.directive("datepicker", function () {
	return {
		restrict: "A",
		link: function (scope, el, attr) {
			el.datepicker({
				dateFormat: 'yy-mm-dd'
					});
			}
	};	
});