package com.testCompany.demo.service;

public class ActivationException extends RuntimeException {
	private static final long serialVersionUID = -5387552281433936787L;

	public ActivationException(String message) {
		super(message);		
	}
	
	public ActivationException(String message, Exception exception) {
		super(message, exception);
	}
}
