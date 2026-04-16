package com.hr.service;

import com.hr.Dto.LoginDto;
import com.hr.Dto.UserDetailsDto;
import com.hr.entites.EmployessList;

public interface UserCreationService {
	
	EmployessList userCreation(UserDetailsDto employessList);
	
	EmployessList validateLoginCredentials(LoginDto loginDto);

}
