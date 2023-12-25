package com.app.dto;

import java.time.LocalDateTime;


import com.app.entities.Category;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RailwayReq {
	
	private Long id;
	private String name;
	private Category type;	
    @JsonFormat(pattern = "HH:mm:ss")

	private LocalDateTime startTime;
    @JsonFormat(pattern = "HH:mm:ss")

	private LocalDateTime endTime;
	private String source;
	private String destiation;
	
	

}
