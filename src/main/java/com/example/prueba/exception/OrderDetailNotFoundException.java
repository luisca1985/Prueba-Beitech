package com.example.prueba.exception;

public class OrderDetailNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderDetailNotFoundException(int id) {
		super("Could not find order detail " + id);
		}
	}