package com.example.prueba.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "Customer")
@Table(name = "\"customer\"")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"customer_id\"")
	private int customerId;
	@Column(name = "\"name\"", length = 191)
	private String name;
	@Column(name = "\"email\"", length = 191)
	private String email;
	
	public Customer(){}
	
	public Customer(String name, String email){
		this.name = name;
		this.email = email;
	}
}
