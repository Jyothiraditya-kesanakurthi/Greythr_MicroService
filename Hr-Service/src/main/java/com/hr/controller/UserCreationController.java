package com.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.Dto.LoginDto;
import com.hr.Dto.UserDetailsDto;
import com.hr.config.JwtUtil;
import com.hr.entites.EmployessList;
import com.hr.service.UserCreationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hr")
public class UserCreationController {

	@Autowired
	private UserCreationService userCreationService;

	private final JwtUtil jwtUtil;

	/*
	 * @GetMapping("/home") public String home() { return "view/signup"; }
	 * 
	 * @GetMapping("/signIn") public String loginPage() { return "view/login"; }
	 * 
	 * @GetMapping("/homePage") public String homePage() { return "view/home"; }
	 */

	@PostMapping("/createUser")
	public String createUser(@RequestBody UserDetailsDto userDetails) {

		EmployessList userSavedRecord = userCreationService.userCreation(userDetails);
		if (userSavedRecord != null) {
			return "User created successfully";
		}

		return "view/signup";

	}

	@PostMapping("/login")
	public String login(@RequestBody LoginDto loginDto) {

		EmployessList user = userCreationService.validateLoginCredentials(loginDto);

		
		String finalToken = jwtUtil.generateToken(user.getEmpNetworkId(), user.getRole().name());
		
		System.out.println(finalToken);
		return finalToken;
	}
	
	@GetMapping("/home")
	public String hrHome() {
		return "This is Hr home";
	}
}
