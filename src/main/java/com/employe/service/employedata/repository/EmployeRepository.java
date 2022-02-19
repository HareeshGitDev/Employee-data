package com.employe.service.employedata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employe.service.employedata.model.Employe;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {
	@Query(nativeQuery=true, value="SELECT * FROM employe ORDER BY id ASC;")	
	public List<Employe> getAllEmployeByOrder();
}
