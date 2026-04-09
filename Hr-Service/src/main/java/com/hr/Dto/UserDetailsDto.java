package com.hr.Dto;

import lombok.Data;

@Data
public class UserDetailsDto {

	private String empName;

	private String empNetworkId;

	private String password;

	private String desgination;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpNetworkId() {
		return empNetworkId;
	}

	public void setEmpNetworkId(String empNetworkId) {
		this.empNetworkId = empNetworkId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesgination() {
		return desgination;
	}

	public void setDesgination(String desgination) {
		this.desgination = desgination;
	}

}
