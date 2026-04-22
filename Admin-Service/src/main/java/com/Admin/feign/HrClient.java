package com.Admin.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.Admin.Dto.LoginDto;

@FeignClient(name="Hr-Service")
public interface HrClient {

	@PostMapping("/hr/login")
	String validateLoginCredentials(LoginDto loginDto);

}
