package com.Emp.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Emp.Dto.LoginDto;



@FeignClient(name="Hr-Service")
public interface HrClient {

	
	@PostMapping("/hr/login")
	 String validateLoginCredentials(@RequestBody LoginDto loginDto);
}
