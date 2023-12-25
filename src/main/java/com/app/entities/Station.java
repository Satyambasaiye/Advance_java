package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Stations")
@Getter
@Setter

public class Station extends BaseEntity{
	public Station(String code, String name, int no_of_platforms) {
		super();
		this.code = code;
		this.name = name;
		this.no_of_platforms = no_of_platforms;
		this.rail = rail;
	}

	@Column(name = "station_code",length = 10,nullable = false,unique = true)
	private String code;
	@Column(name="station_name",length = 30,nullable = false)
	private String name;
	@Column(nullable = false)
	private int no_of_platforms;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Railway rail;
	public Station() {
		// TODO Auto-generated constructor stub
	}
	

}
