package com.Admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Admin.Dto.LoginDto;

@RestController
@RequestMapping("/admin")
public class AdminController {
	


	
	@GetMapping("/home")
	public String hrHome() {
		return "This is Hr home";
	}
}
