package com.manoj.exception;

public class ResourceNotFoundException extends RuntimeException {

	
	public ResourceNotFoundException() {
		
		super("Resouce Not found Server...!!!");
	}
	
	public ResourceNotFoundException(String message) {
		
		super(message);
	}
	
}
