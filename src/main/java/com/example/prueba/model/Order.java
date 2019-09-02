package com.example.prueba.model;


import java.util.Date;

import javax.persistence.*;
import lombok.Data;

@Data // Crea todos los métodos getters, setters, equals, hash y toString, en función de los campos.
@Entity(name = "Order") // Prepara este objeto para almacenarlo en un almacén de datos basado en JPA
@Table(name = "\"order\"") // Se indica el nombre de la tabla de la base de datos a la que corresponde. Se utiliza \"order\" que representa el nombre "order" (entre comillas), ya que palabra order es una palabra reservada de mysql.
public class Order{
	@Id // Indica que es la clave principal al proveedor JPA
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que se llena automáticamente por el proveedro JPA
	@Column(name = "\"order_id\"") // Indica la información de la columna en la base de datos
	private int orderId;
	@ManyToOne
	@JoinColumn(name="\"customer_id\"")
	private Customer customer;
	@Column(name = "\"creation_date\"")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
	@Column(name = "\"delivery_address\"", length = 191)
	private String deliveryAddress;
	@Column(name = "\"total\"", precision = 15, scale = 2)
	private double total;
	
	public Order(){}
	
	public Order(Customer customer, Date creationDate, String deliveryAddress, double total){
		this.customer = customer;
		this.creationDate = creationDate;
		this.deliveryAddress = deliveryAddress;
		this.total = total;
	}
}
