package com.example.prueba.model;


import java.util.Date;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Order")
@Table(name = "\"order\"")
public class Order{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"order_id\"")
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
