package com.employe.service.employedata.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employe.service.employedata.service.EmployeService;
import com.employe.service.employedate.dto.EmployeeRequestDTO;
import com.employe.service.employedate.dto.EmployeeResponseDTO;
import com.employe.service.employeedata.validation.MailValidation;

@RestController
public class EmployeController {
	@Autowired
	private EmployeService employeService;

	@RequestMapping("/employee/{id}")
	public ResponseEntity<EmployeeResponseDTO> getEmploye(@PathVariable long id) {
		EmployeeResponseDTO employee;
		try {
			employee = employeService.getEmployee(id);
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.accepted().body(employee);
	}

	@RequestMapping("/employee")
	public List<EmployeeResponseDTO> getAllEmploye() {
		return employeService.getAllEmployee();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/employee")
	public ResponseEntity<EmployeeResponseDTO> addEmploye(@RequestBody EmployeeRequestDTO employeRequestDto) {
		MailValidation val = new MailValidation();
		EmployeeResponseDTO response;
		if (val.doValidation(employeRequestDto.getEmail()) == true) {
			try {
				response = employeService.addEmployee(employeRequestDto);
				return ResponseEntity.accepted().body(response);
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e);
				return ResponseEntity.badRequest().build();
			}
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/employee")
	public ResponseEntity<EmployeeResponseDTO> updateEmploye(@RequestBody EmployeeRequestDTO employeRequestDto) {
		MailValidation val = new MailValidation();
		EmployeeResponseDTO res = new EmployeeResponseDTO();
		if (val.doValidation(employeRequestDto.getEmail()) == true) {
			try {
				res = employeService.updateEmployee(employeRequestDto);
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e);
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.accepted().body(res);
		}
		return ResponseEntity.badRequest().build();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
	public ResponseEntity<String> deleteEmploye(@PathVariable long id) {
		try {
			employeService.deleteEmployee(id);
			return ResponseEntity.accepted().build();
		} catch (IndexOutOfBoundsException e) {
			System.out.print(e);
			return ResponseEntity.badRequest().build();

		}

	}

}
