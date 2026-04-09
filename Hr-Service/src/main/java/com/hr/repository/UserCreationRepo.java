package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.Dto.LoginDto;
import com.hr.entites.UserDetails;

@Repository
public interface UserCreationRepo extends JpaRepository<UserDetails, Long>{
	
	
	public UserDetails findByempNetworkId(String  empNetworkId);
	

}
