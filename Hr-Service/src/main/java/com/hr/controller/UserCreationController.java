package com.hr.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@PostMapping("/createUser")
	public String createUser(@RequestBody UserDetailsDto userDetails) {

		EmployessList userSavedRecord = userCreationService.userCreation(userDetails);
		if (userSavedRecord != null) {
			return "User created successfully";
		}

		return "Error";

	}

	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody LoginDto loginDto) {

		EmployessList user = userCreationService.validateLoginCredentials(loginDto);

		String token = jwtUtil.generateToken(user.getEmpNetworkId(), user.getRole().name());

		System.out.println(token);
		return Map.of("token", token, "user",
				new UserDetailsDto(user.getEmpName(), user.getEmpNetworkId(), user.getDesgination(), user.getRole()));
	}

}
