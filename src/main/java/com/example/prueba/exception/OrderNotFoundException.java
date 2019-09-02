package com.example.prueba.exception;

public class OrderNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(int id) {
		super("Could not find order " + id);
		}
	}