package com.skilldistillery.newparent.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.newparent.services.NewParentService;

@RequestMapping("api")
@RestController
public class NewParentController {
	
	@Autowired
	private NewParentService svc;
	
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}

}
