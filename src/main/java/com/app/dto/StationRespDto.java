package com.app.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationRespDto {

	private String code;
	private String name;
	private int no_of_platforms;
}
