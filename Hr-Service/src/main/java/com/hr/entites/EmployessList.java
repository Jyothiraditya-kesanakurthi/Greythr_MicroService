package com.hr.entites;

import com.hr.util.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Details")
public class EmployessList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Employee_Name")
	private String empName;
	
	
	@Column(name="Employee_Network_Id" ,unique = true)
	private String empNetworkId;
	
	private String password;
	
	@Column(name ="Employe_Desgination")
	private String desgination;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	public EmployessList(Long id, String empName, String empNetworkId, String password, String desgination, Role role) {
		super();
		this.id = id;
		this.empName = empName;
		this.empNetworkId = empNetworkId;
		this.password = password;
		this.desgination = desgination;
		this.role = role;
	}

	public EmployessList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
	
	
}
