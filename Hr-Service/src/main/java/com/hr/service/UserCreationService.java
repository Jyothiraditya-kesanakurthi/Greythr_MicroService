package com.hr.service;

import com.hr.Dto.LoginDto;
import com.hr.Dto.UserDetailsDto;
import com.hr.entites.UserDetails;

public interface UserCreationService {
	
	UserDetails userCreation(UserDetailsDto userDetails);
	
	UserDetails validateLoginCredentials(LoginDto loginDto);

}
