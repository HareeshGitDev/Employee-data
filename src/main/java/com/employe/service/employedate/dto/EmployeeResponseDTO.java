package com.employe.service.employedate.dto;

import java.util.Date;

import com.employe.service.employedata.model.Employe;

public class EmployeeResponseDTO {
	private long id;
	private String name;
	private String email;
	private Date dob;
	private int age;
	private double salary;
	private boolean status;
	
	public EmployeeResponseDTO() {
		super();
	}
	public EmployeeResponseDTO(Employe emp) {
		super();
		this.id = emp.getId();
		this.name = emp.getName();
		this.email = emp.getEmail();
		this.dob = emp.getDob();
		this.age = emp.getAge();
		this.salary = emp.getSalary();
		this.status = emp.isStatus();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
