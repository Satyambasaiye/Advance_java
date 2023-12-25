package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.StationService;

@RestController
@RequestMapping("/station")
public class StationController {
	@Autowired
	StationService stationService;
	
	/*
	 * url: station/add     method:post
	 * return list;
	 */
	
	@GetMapping("/add")
	public ResponseEntity<?> getAllStations()
	{
		return ResponseEntity.ok(stationService.getAllStations());
	}
	
	

}
