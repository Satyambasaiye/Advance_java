package com.app.custome_exception;

public class BadRequest extends RuntimeException 
{
	String msg;
	BadRequest(String msg)
	{
		super (msg);
	}

}
