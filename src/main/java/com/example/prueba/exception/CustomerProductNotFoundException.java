package com.example.prueba.exception;

public class CustomerProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerProductNotFoundException(String id) {
		super("Could not find customer product " + id);
		}
	}