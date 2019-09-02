package com.example.prueba.exception;

public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(int id) {
		super("No se pudo encontrar Customer con Id: " + id);
		}
	}