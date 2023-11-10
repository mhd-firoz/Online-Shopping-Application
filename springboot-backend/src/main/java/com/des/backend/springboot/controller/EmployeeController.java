package com.des.backend.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.des.backend.springboot.model.Employee;
import com.des.backend.springboot.service.EmployeeService;

@RestController
@RequestMapping("/tcs/employee")
public class EmployeeController {
	
	private EmployeeService employeeService ;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// build creat employee REST API
@PostMapping()
public ResponseEntity<Employee> saveEmployee(Employee emp)
{
	
	return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
}

}
