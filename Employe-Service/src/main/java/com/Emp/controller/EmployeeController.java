package com.Emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Emp.Dto.LoginDto;
import com.Emp.feign.HrClient;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	/*
	 * @Autowired HrClient hrClient;
	 * 
	 * @PostMapping("/login") public String validateEmpCredentials(@RequestBody
	 * LoginDto loginDetails)
	 * 
	 * {
	 * 
	 * return hrClient.validateLoginCredentials(loginDetails); }
	 */
	
	@GetMapping("/Home")
	public String empHome() {
		return " This is Employe home";
	}
}
