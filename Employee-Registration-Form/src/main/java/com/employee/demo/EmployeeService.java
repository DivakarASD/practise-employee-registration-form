package com.employee.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<EmployeeDetails> listAll(String keyword){
		
		if (keyword != null) {
			return employeeRepository.findAll(keyword);
		}
		return employeeRepository.findAll();
	}
}
