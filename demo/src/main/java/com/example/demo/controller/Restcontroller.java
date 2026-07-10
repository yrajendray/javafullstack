package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Restcontroller {
	
	@GetMapping("/start")
	public String get() {
		return "Spring boot Started.";
	}

}
