package com.testCompany.demo.service;

public class ActivationExpiredException extends RuntimeException {
	private static final long serialVersionUID = 3043980484231155335L;

	public ActivationExpiredException(String message) {
		super(message);		
	}
	
	public ActivationExpiredException(String message, Exception exception) {
		super(message, exception);
	}
}
