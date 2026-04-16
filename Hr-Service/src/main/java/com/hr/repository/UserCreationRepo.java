package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.entites.EmployessList;

@Repository
public interface UserCreationRepo extends JpaRepository<EmployessList, Long>{
	
	
	public EmployessList findByempNetworkId(String  empNetworkId);
	

}
