package com.employee.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class FormController {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/login")
	public String login() {
		System.out.println("Login request...");
		return "login";
	}
	
	@GetMapping("/index")
	public String getAllEmployees(Model model, @Param("keyword") String keyword){
		List<EmployeeDetails> employeeList = service.listAll(keyword);
		model.addAttribute("employees", employeeList);
		return "index";
  	}
	
	@GetMapping("/form")
	public String form() {
//		System.out.println("Request....");
		return "form";
	}
	
	@GetMapping("/editForm/{code}")
	
	public String updateEmployee(@PathVariable(value = "code") int empcode, Model model) {
		Optional<EmployeeDetails> optional = repository.findById(empcode);
		EmployeeDetails employeeDetails = null;
		if (optional.isPresent()) {
			employeeDetails = optional.get();			
		}else {
			throw new RuntimeException("No employee record for given employee code :: " + empcode);
		}
		
		model.addAttribute("employee", employeeDetails);
		return "editForm"; 
	}
	
	@GetMapping("/deleteEmployee/{code}")
	public String deleteEmployee(@PathVariable(value = "code") int empcode, Model model) {
		repository.deleteById(empcode);
		return "redirect:/index";
	}
	
	@PostMapping("/form")
	public String dtls(@ModelAttribute EmployeeDetails employeeDetails, Model model) {
		
//		System.out.println(employeeDetails);
		repository.save(employeeDetails);
//		model.addAttribute("successMessage", "Employee added successfully!");
		return "redirect:/index";
		
	}	
}
