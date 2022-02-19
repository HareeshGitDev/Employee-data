package com.employe.service.employedata.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.employe.service.employedate.dto.EmployeeRequestDTO;

@Entity
public class Employe {
	@Id
	private long id;
	private String name;
	private String email;
	private int age;
	private Date dob;
	private double salary;
	private boolean status;
	public Employe() {
		super();
	}
	public Employe(EmployeeRequestDTO reqDTO) {
		super();
		this.id = reqDTO.getId();
		this.name = reqDTO.getName();
		this.email = reqDTO.getEmail();
		this.dob = reqDTO.getDob();
		this.salary = reqDTO.getSalary();
		this.status = reqDTO.isStatus();
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
