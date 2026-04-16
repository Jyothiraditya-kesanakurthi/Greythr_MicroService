package com.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hr.entites.EmployessList;
import com.hr.repository.UserCreationRepo;

@Service
public class CustomeUserDetailsService implements UserDetailsService {

	
	@Autowired
	UserCreationRepo  userCreationRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		EmployessList employeeList =  userCreationRepo.findByempNetworkId(username) ;
		
		if(employeeList ==null) {
            throw new UsernameNotFoundException("User not found");

		}
		return new CustomUserDetails(employeeList);
	}

}
