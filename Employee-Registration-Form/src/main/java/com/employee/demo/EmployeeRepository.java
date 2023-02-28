package com.employee.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {
	
	@Query(value = "SELECT * FROM employee_details e WHERE e.empcode = ?1 "
			+ "OR e.employee_name LIKE %?1% "
			+ "OR e.docnum = ?1 "
			+ "OR e.dob = ?1 "
			+ "OR e.curr_date = ?1 "
			+ "OR e.address = ?1", nativeQuery = true)
	public List<EmployeeDetails> findAll(String keyword);
}
