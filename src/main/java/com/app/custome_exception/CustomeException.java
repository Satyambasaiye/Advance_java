package com.app.custome_exception;


public class CustomeException extends RuntimeException {
	String mesg;
	public CustomeException(String msg) {
		super(msg);
	}
	

}
