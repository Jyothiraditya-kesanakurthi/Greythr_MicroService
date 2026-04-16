package com.hr.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	
	
	public void setId(long id) {
		this.id=id;
	}
	
	public long getId() {
		return id;
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
	
	
	
	public EmployessList(long id,String empName, String empNetworkId, String password, String desgination) {
		this.id =id;
		this.empName =empName;
		this.empNetworkId = empNetworkId;
		this.password =password;
		this.desgination = desgination;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", empName=" + empName + ", empNetworkId=" + empNetworkId + ", password="
				+ password + ", desgination=" + desgination + "]";
	}

	public EmployessList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
