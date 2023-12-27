package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Railways")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(of = "name",callSuper = false)
//@AttributeOverride(name="id", column = @Column(name = "Train_no"))
public class Railway extends BaseEntity{
	@Column(name = "name", length = 20,nullable = false,unique = true)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(name = "Train_type",length = 20,nullable = false)
	private Category type;
	@Column(name = "Start_time",length = 30,nullable = false)
	private LocalDateTime startTime;
	@Column(name="End_time",length = 30,nullable = false)
	private LocalDateTime endTime;
	@Column(length = 20,nullable = false)
	private String source;
	@Column(length = 20,nullable = false)
	private String destiation;
	@OneToMany(mappedBy = "rail",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Station> stations=new ArrayList<Station>();
	public Railway() {
		// TODO Auto-generated constructor stub
	}
	
	public void addStation(Station st)
	{
		stations.add(st);
		st.setRail(this);
		
	}
	
	public void removeStation(Station st)
	{
		stations.remove(st);
		st.setRail(null);
	}

	public Railway(String name, Category type, LocalDateTime startTime, LocalDateTime endTime, String source, String destiation) {
		super();
		this.name = name;
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
		this.source = source;
		this.destiation = destiation;
		this.stations = stations;
	}

}
