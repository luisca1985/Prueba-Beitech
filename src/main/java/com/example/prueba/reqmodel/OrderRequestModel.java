package com.example.prueba.reqmodel;


import java.util.List;

import lombok.Data;

@Data
public class OrderRequestModel {
	private int customerId;
	private String deliveryAddress;
	private List<ProductQuantityRequestModel> products;
}