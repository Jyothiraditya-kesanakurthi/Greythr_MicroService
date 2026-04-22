package com.hr.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hr.entites.EmployessList;

public class CustomUserDetails implements UserDetails {

	private EmployessList employeeList;

	public CustomUserDetails(EmployessList employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + employeeList.getRole()));

	}

	@Override
	public String getPassword() {
		return employeeList.getPassword();
	}

	@Override
	public String getUsername() {
		return employeeList.getEmpNetworkId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}