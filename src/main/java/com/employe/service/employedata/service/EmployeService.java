package com.employe.service.employedata.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employe.service.employedata.model.Employe;
import com.employe.service.employedata.repository.EmployeRepository;
import com.employe.service.employedate.dto.EmployeeRequestDTO;
import com.employe.service.employedate.dto.EmployeeResponseDTO;
import com.employe.service.employeedata.operation.FindAgeFromDate;

@Service
public class EmployeService {
	@Autowired
	private EmployeRepository employeRepository;

	public EmployeeResponseDTO getEmployee(long id) {
		Optional<Employe> emp;
		emp = employeRepository.findById(id);
		if (emp.isEmpty()) {
			throw new IndexOutOfBoundsException("Id " + id + " not available in database");
		} else {
			Employe employe = emp.get();
			EmployeeResponseDTO response = new EmployeeResponseDTO(employe);
			return response;
		}
	}

	public List<EmployeeResponseDTO> getAllEmployee() {
		List<Employe> emp = new ArrayList<>();
		List<EmployeeResponseDTO> response = new ArrayList<EmployeeResponseDTO>();
		emp = (List<Employe>) employeRepository.getAllEmployeByOrder();
		for (int i = 0; i < emp.size(); i++) {
			EmployeeResponseDTO res = new EmployeeResponseDTO(emp.get(i));
			response.add(res);
		}
		return response;
	}

	public EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeRequestDTO) {
		Optional<Employe> emp;
		emp = employeRepository.findById(employeRequestDTO.getId());
		if (emp.isEmpty()) {
			Employe employe = new Employe(employeRequestDTO);
			Date date = new Date();
			FindAgeFromDate findAge = new FindAgeFromDate();
			employe.setAge(findAge.getAge(date, employeRequestDTO.getDob()));
			employeRepository.save(employe);
			EmployeeResponseDTO response = new EmployeeResponseDTO(employe);
			return response;
		} else {
			throw new IndexOutOfBoundsException("Id " + employeRequestDTO.getId() + " already exits");
		}

	}

	public EmployeeResponseDTO updateEmployee(EmployeeRequestDTO employeRequestDTO) {
		Optional<Employe> employee;
		employee = employeRepository.findById(employeRequestDTO.getId());
		if (employee.isEmpty()) {
			throw new IndexOutOfBoundsException("Employee id " + employeRequestDTO.getId() + " not in the table");
		} else {
			FindAgeFromDate findAge = new FindAgeFromDate();
			Date date = new Date();
			Employe emp = new Employe(employeRequestDTO);
			emp.setAge(findAge.getAge(date, employeRequestDTO.getDob()));
			employeRepository.save(emp);
			EmployeeResponseDTO response = new EmployeeResponseDTO(emp);
			return response;
		}
	}

	public void deleteEmployee(long id) {
		Optional<Employe> employe;
		employe = employeRepository.findById(id);
		if (employe.isEmpty()) {
			throw new IndexOutOfBoundsException("id " + id + "does not exit");
		} else {
			employeRepository.deleteById(id);
		}
	}

}
