package com.hr.entites;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class AttendenceBook {

	@Id
	private long id;
	@Column(name="Employee_Name")
	private String empName;
	
	@Column(name="Employee_Network_Id")
	private String empNetworkId;
	
	@Column(name="LoginTime")
	private Timestamp logInTime;
	
	@Column(name="LogOutTime")
	private Timestamp logOutTime;
	
	@Column(name="LastLoginTime")
	private Timestamp lastLogInTime;
	
	@Column(name="LastLogoutTime")
	private Timestamp lastLogOutTime;
	
	private String status;
	
}
