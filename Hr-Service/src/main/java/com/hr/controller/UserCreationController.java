package com.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.Dto.LoginDto;
import com.hr.Dto.UserDetailsDto;
import com.hr.entites.UserDetails;
import com.hr.service.UserCreationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hr")
@RequiredArgsConstructor
public class UserCreationController {

	@Autowired
	private UserCreationService userCreationService;

	@PostMapping("/createUser")
	public String createUser(@RequestBody UserDetailsDto userDetails) {
		
		UserDetails userSavedRecord=userCreationService.userCreation(userDetails);
		if(userSavedRecord !=null) {
		return "User Created Successfully";
		}
		
		return "User Creation failed";
		
	}
	
	@PostMapping("/login")
	public String validateLoginCredentials(@RequestBody LoginDto loginDto) {

	    UserDetails user = userCreationService.validateLoginCredentials(loginDto);

	    return "Hi " + user.getEmpName();
	}
}
