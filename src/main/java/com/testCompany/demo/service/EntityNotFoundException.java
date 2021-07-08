package com.testCompany.demo.service;

public class EntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -6530121337899773295L;

	public EntityNotFoundException(String message) {
		super(message);		
	}
	
	public EntityNotFoundException(String message, Exception exception) {
		super(message, exception);
	}
}
