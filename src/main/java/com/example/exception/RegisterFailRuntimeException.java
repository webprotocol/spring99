package com.example.exception;

public class RegisterFailRuntimeException extends RuntimeException {
	
	public RegisterFailRuntimeException() {
		
	}
	
	public RegisterFailRuntimeException(String msg) {
		super(msg);
	}

}
