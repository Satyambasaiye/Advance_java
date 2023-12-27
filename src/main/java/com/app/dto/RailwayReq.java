package com.app.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.hibernate.annotations.Type;

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

	private LocalDateTime startTime;

	private LocalDateTime endTime;
	private String source;
	private String destiation;
	
	

}
