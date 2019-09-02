// Crea el controlador para AngularJS
module.controller("appCtrl", [ "$scope", "$http", function($scope, $http) {
	// Se crea una variable para alamacenar la lista de clientes y el cliente seleccionado
	$scope.customers = {
			// Variable para almacenar el id del cliente selecionado
			"customerSelected": 0,
			// Variable para almacenar los clientes de la base de datos.
			"customerOptions": []
	};
	
	// Se crea una variable para almacenar los valores que se utilizarán para el Request:
	$scope.params = {
		"id": 0, // contiene el id del cliente elegido
		"from": "", // contiene la fecha desde la cual se obtendrá el listado de ordenes
		"to": "" // contiene la fecha hasta la cual se obtendrá el listado de ordenes
	};
	
	// Variable que deshabilita las entradas mientras se cargan los valores de la base de datos
	$scope.disabled = true;
	
	// Se crea la variables que contendrá los valores de las órdenes del cliente elegido
	$scope.orderDetails = [];
	
	// La función obtiene los valores de la base de datos
	$scope.getOrders = function () {
		// Se deshabilitan los controles mientras
		$scope.disabled = true;
		// Configura los parámetros de la solicitud del listado de ordenes
		$scope.params.id = $scope.customers.customerSelected; // ID del cliente
		$scope.params.from = $scope.dateFrom; // Fecha desde la cual se obtienen las órdenes
		$scope.params.to = $scope.dateTo; // Fecha hasta la cual se obtienen las órdenes
		
		// Se realiza el pedido de las órdenes a la a base de datos
		$http.get('/pruebaorder', {
			params: $scope.params
		}).then(successCallback, errorCallback);
		// Se obtiene la respuesta del Request GET
		function successCallback(response){
			$scope.orderDetails = response.data; // Se obtiene la respuesta
			$scope.disabled = false; // Se habilitan nuevamente los controles
			
			// Se ajusta la respuesta de entrada para que se ajuste al informe en HTML
			$scope.ordersPerCustomer = $scope.orderDetails
			// Se obtienen únicamente las variables del informe
			//Los datos no se utilizan se descartan
			.map(function(ordrDtl){
				return {
					"creationDate" : ordrDtl.order.creationDate,
					"orderId": ordrDtl.order.orderId,
					"total": ordrDtl.order.total,
					"deliveryAddress": ordrDtl.order.deliveryAddress,
					"quantity" : ordrDtl.quantity,
					"product": ordrDtl.product.name
				}
			})
			// Se organizan los campos por ID de la órden
			.sort((a,b) => a.orderId - b.orderId)
			// Modifica la matriz para productos y sus cantidades se incluyan en un registro por órden.
			// Para esto se crea un array de objetos que contienen los productos y sus cantidad por cada órden.
			.reduce((acc, cur, idx, src) => {
				if( (idx < 1? false: cur.orderId === src[idx - 1].orderId )){
					acc[acc.length - 1].products.push({
						"quantity" : cur.quantity,
						"product" : cur.product
					});
				}
				else{
					acc.push({
						"creationDate" : cur.creationDate,
						"orderId": cur.orderId,
						"total": cur.total,
						"deliveryAddress": cur.deliveryAddress,
						"products": [
							{
								"quantity" : cur.quantity,
								"product" : cur.product
							}
							]
					});
				}
				// Devuelve la matriz con los datos organizados de acuerdo al requerimiento.
				// Listo para graficar.
				return acc;
			},[]);
			
		}
		function errorCallback(error){
			
		}
	}
	
	// Se obtienen los clientes de la base de datos.
	// Se debe realizar esto para poder generar el reporte.
	$http.get('/customers').then(successCallback, errorCallback);
	function successCallback(response){
		$scope.customers.customerOptions = response.data;
		// Se habilitan los controles una vez se ha cargado el listado.
		$scope.disabled = false;
	}
	function errorCallback(error){
		
	}
	

}]);