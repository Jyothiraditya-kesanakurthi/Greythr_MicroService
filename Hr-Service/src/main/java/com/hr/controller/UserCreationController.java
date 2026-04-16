package com.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hr.Dto.UserDetailsDto;
import com.hr.entites.EmployessList;
import com.hr.service.UserCreationService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
@RequestMapping("/hr")
public class UserCreationController {

	@Autowired
	private UserCreationService userCreationService;
	
	@GetMapping("/home")
	public String home() {
		return"view/signup";
	}
	
	@GetMapping("/signIn")
	public String loginPage() {
		return"view/login";
	}
	
	@GetMapping("/homePage")
	public String homePage() {
		return"view/home";
	}
	
	

	@PostMapping("/createUser")
	public String createUser(UserDetailsDto userDetails) {
		
		EmployessList userSavedRecord=userCreationService.userCreation(userDetails);
		if(userSavedRecord !=null) {
		return "view/login";
		}
		
		return "view/signup";
		
	}
	
	/*
	 * @PostMapping("/login") public String validateLoginCredentials(LoginDto
	 * loginDto) {
	 * 
	 * EmployessList user = userCreationService.validateLoginCredentials(loginDto);
	 * 
	 * if(user !=null) { return"view/home.html"; }
	 * 
	 * return "view/Error.html"; }
	 */
}
