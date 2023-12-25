package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RailwayReq;
import com.app.dto.RailwayRespDto;
import com.app.entities.Category;
import com.app.entities.Railway;
import com.app.service.RailwayService;


@RestController
@RequestMapping("/railway")
public class RailwayController {
	@Autowired
	private RailwayService railService;
	
	/*
	 * uri:  railway/add     method: post
	 * return : persistent dto 
	 *  
	 */
	
	@PostMapping("/add")
	public ResponseEntity<?> addRailway(@RequestBody RailwayReq rail)
	{
		
		System.out.println("in controller---->"+rail);
		
		return ResponseEntity.status(HttpStatus.OK).body(railService.addRailway(rail));
	}
	
	// /railway/delete
	//method:get
	
	@GetMapping("/delete")
	public ResponseEntity<?>deleteRailway(@RequestParam Long id)
	{
		System.out.println("in controller id: "+id);
		
		return ResponseEntity.ok(railService.deleteRailway( id));
		
	}
	// railway/display   method: get
	//return message
	@GetMapping("/display")
	public ResponseEntity<?>getRailwayByCategory(@RequestParam Category category)
	{

		List<RailwayRespDto> list = railService.getRailwayByCategory(category);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("railway not found of specified category");
		
		return ResponseEntity.ok(list);
	}

}
