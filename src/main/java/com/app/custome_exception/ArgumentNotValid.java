package com.app.custome_exception;


public class ArgumentNotValid extends RuntimeException {
	String mesg;
	public ArgumentNotValid(String msg) {
		super(msg);
	}
	

}
