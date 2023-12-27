package com.app.Exception_handler;

import com.app.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.custome_exception.CustomeException;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ApiResponse otherAnyException(RuntimeException e)
	{
		System.out.println("internal server error !!!!"+e);
		return new ApiResponse (e.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> badRequestHandler(MethodArgumentNotValidException e)
	{
		System.out.println("bad request!!"+e.getCause());
		
		return ResponseEntity.badRequest().body(e);
	}
	@ExceptionHandler(CustomeException.class)
	public ApiResponse customeExceptionHandler(CustomeException e)
	
	{
		System.out.println("custome exception !!!"+e.getMessage());
		return new ApiResponse(e.getMessage());
	}

}
