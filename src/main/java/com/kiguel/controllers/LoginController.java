package com.kiguel.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/login")
	public String googleLogin() {
		
		return "logged in!";
	}
	
	@GetMapping("/")
	public String aloMundo() {
		
		return "Alo Mundão!";
	}
}
