package com.example.prueba.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data; 

@Data
@Embeddable
public class CustomerProductId implements Serializable{

	private static final long serialVersionUID = 1359397122293160199L;
	
	@ManyToOne
	@JoinColumn(name = "\"customer_id\"")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "\"product_id\"")
	private Product product;
	
	public CustomerProductId() {}
	
	public CustomerProductId(Customer customer, Product product) {
		this.customer = customer;
		this.product = product;
	}
}
