package com.hr.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hr.Dto.LoginDto;
import com.hr.Dto.UserDetailsDto;
import com.hr.entites.EmployessList;
import com.hr.repository.UserCreationRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserCreationServiceImpl implements UserCreationService {

	@Autowired
	UserCreationRepo userCreationRepo;

	@Autowired
	private final PasswordEncoder passwordEncoder;

	@Override
	public EmployessList userCreation(UserDetailsDto userDetails) {

		EmployessList user = new EmployessList();
		BeanUtils.copyProperties(userDetails, user);

		user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
		EmployessList Newuser = userCreationRepo.save(user);

		return Newuser;

	}

	public EmployessList validateLoginCredentials(LoginDto loginDto) {

		EmployessList user = userCreationRepo
	            .findByempNetworkId(loginDto.getEmpNetworkId());

	    // Check user exists
	    if (user == null) {
	        throw new RuntimeException("Invalid credentials");
	    }

	    // Validate password
	    if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
	        return user;
	    }

	    throw new RuntimeException("Invalid credentials");
	}

}
