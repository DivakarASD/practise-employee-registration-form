package com.employee.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EmployeeDetails")
public class EmployeeDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empcode;
	
	@Column(name = "Employee_Name")
	private String empname;
	
	
//	private int empcode;
	private String dob;
	
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int docnum;
	
	private String address;
	private String currDate;
	
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmpcode() {
		return empcode;
	}
	public void setEmpcode(int empcode) {
		this.empcode = empcode;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getDocnum() {
		return docnum;
	}
	public void setDocnum(int docnum) {
		this.docnum = docnum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCurrDate() {
		return currDate;
	}
	public void setCurrDate(String currDate) {
		this.currDate = currDate;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [empname=" + empname + ", empcode=" + empcode + ", dob=" + dob + ", docnum=" + docnum
				+ ", address=" + address + ", currDate=" + currDate + "]";
	}
	
	
	
	
	
}
