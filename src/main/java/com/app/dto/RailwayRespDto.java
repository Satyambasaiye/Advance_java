package com.app.dto;


import com.app.entities.Category;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RailwayRespDto {
	private Long id;
	private String name;
	private Category type;	
   
	private String source;
	private String destiation;
	

}
