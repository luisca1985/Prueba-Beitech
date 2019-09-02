package com.example.prueba.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity(name = "OrderDetail")
@Table(name = "\"order_detail\"")
public class OrderDetail{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"order_detail_id\"")
	private int orderDetailId;
	@ManyToOne
	@JoinColumn(name="\"order_id\"")
	private Order order;
	@ManyToOne
	@JoinColumn(name="\"product_id\"")
	private Product product;
	@Column(name = "\"product_description\"", length = 191)
	private String productDescription;
	@Column(name = "\"price\"", precision = 10, scale = 2)
	private double price;
	@Column(name = "\"quantity\"")
	private int quantity;
	
	public OrderDetail(){}
	
	public OrderDetail(Order order, Product product, int quantity){
		this.order = order;
		this.product = product;
		this.productDescription = product.getProductDescription();
		this.price = product.getPrice();
		this.quantity = quantity;
	}

}
