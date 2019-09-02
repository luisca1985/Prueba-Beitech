# Prueba Beitech
Este proyecto contiene los entregables de la prueba indicada por Beitech
## Documentación de los método del API REST
```bash

	@RequestMapping(value="/pruebaorder" , method=RequestMethod.GET)
    @ResponseBody 
    /**
     * Se crea una lista con todas las órdenes a partir del cliente, y un intervalo de fechas.
     * Si no se envían parámetros el listado no filtra las órdenes (envía el listado completo).
     * Los dos parámetros deben tener el siguiente formato de fecha "yyyy-MM-dd".
     * @param customerId El parámetro customerId indica el ID del cliente que generó los reportes.
     * @param fromDate El parámetro fromDate indica la fecha desde la cuál se generará el reporte de órdenes.
     * @param toDate El parámetro toDate indica la fecha hasta la cuál se generará el reporte de órdenes.
     * @return El método retorna la lista de detalles de órden 
     */
    List<OrderDetail> allBetweenPerCutomer(
    		// Se indica el nómbre del parámetro
    		@RequestParam
    		(value = "id", required = false)
    		Integer customerId,
    		// Se indica el nómbre del parámetro
    		@RequestParam
    		(value = "from", required = false) 
    		// Se indica el formato de la fecha
    		@DateTimeFormat
    		(pattern="yyyy-MM-dd") Date fromDate, 
    		@RequestParam
    		(value = "to", required = false) 
    		@DateTimeFormat
    		(pattern="yyyy-MM-dd") Date toDate) {
		//Se obtienen todas la fechas
		return orderDetailRepo.findAll()
				.stream() // se crea un stream
				// se filtran por fecha
				.filter(orderDtl -> {
					// Se obtiene el ID del cliente de al órden.
					int cstmrId = orderDtl.getOrder().getCustomer().getCustomerId();
					// Se obtiene la fecha de creación de la órden
					Date crtnDt = orderDtl.getOrder().getCreationDate();
					// Se indica que si el filtro no existe, no habría por cliente
					// Se aplica el filtro si el valor sí existe 
					return ( customerId == null ? true : customerId == cstmrId )
							// Se indica que si el valor inferior no existe, no habría filtro inferior
							// Se aplica el filtro si el valor sí existe 
							&& (fromDate == null ? true : crtnDt.compareTo(fromDate) >= 0)
							// Se indica que si el valor superio no existe, no habría filtro inferior
							// Se aplica el filtro si el valor sí existe
							&& (toDate == null ? true : crtnDt.compareTo(toDate) <= 0); 
				} )
				.collect(Collectors.toList()); // Se crea una lista
    }
	
	/**

	 */
```
