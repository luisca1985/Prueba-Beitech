package com.example.prueba.exception;

public class ProductQuantityOrderRangeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductQuantityOrderRangeException(int quantity) {
		super("La cantidad total de productos está fuera del rango válido: " + quantity);
		}
	}