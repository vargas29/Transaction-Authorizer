package com.co.lulobank.dominio.exceptions;

public class validateRequiredField extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	public validateRequiredField(String message) {
		super(message);
	}
}
