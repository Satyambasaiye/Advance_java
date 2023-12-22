package com.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
//implicitly  added on ret types of all req handling methods
@RequestMapping("/test") // optional BUT reco.
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}

	// http://host:port/test , method =GET
	// resp : List<Integer>
	@GetMapping
	public List<Integer> testMe() {
		System.out.println("in test me");
		return List.of(1, 2, 3, 4, 5);
	}
	/*
	 * TestController rets --> @ResponseBody List<Integer> 
	 * --> D.S . SC uses Jackson to
	 * martial Java --> JSON --> sent to REST clnt
	 */

}
