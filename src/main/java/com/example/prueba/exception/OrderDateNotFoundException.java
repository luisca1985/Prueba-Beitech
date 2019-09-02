package com.example.prueba.exception;

import java.util.Date;

public class OrderDateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OrderDateNotFoundException(Date date) {
		super("Could not find order date " + date);
		}
	}