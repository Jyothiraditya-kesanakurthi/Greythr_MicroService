package com.Emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Emp.Dto.LoginDto;
import com.Emp.feign.HrClient;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

	@Autowired
	 HrClient hrClient;

	@PostMapping("/login")
	public String validateEmpCredentials(@RequestBody LoginDto loginDetails)

	{

		return hrClient.validateLoginCredentials(loginDetails);
	}
}
