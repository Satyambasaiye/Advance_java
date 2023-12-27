package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {

	String msg;
	LocalDateTime timeStamp;
	public ApiResponse( String msg) {
		// TODO Auto-generated constructor stub
		this.msg=msg;
		this.timeStamp=timeStamp;
	}
}
