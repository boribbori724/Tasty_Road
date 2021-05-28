package com.tasty.error.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

	private String MODULE = "error";
	
	@GetMapping("/auth_error.do")
	public String authError() throws Exception {
		
		return MODULE + "/auth_error";
		
	}
	
	@GetMapping("/login_error.do")
	public String loginError() throws Exception {
		
		return MODULE + "/login_error";
		
	}
	
}
