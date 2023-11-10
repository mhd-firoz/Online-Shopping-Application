package com.des.backend.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.des.backend.springboot.model.Employee;
import com.des.backend.springboot.service.EmployeeService;

@RestController
@RequestMapping("/tcs/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// build creat employee REST API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {

		return new ResponseEntity<Employee>(employeeService.addEmployee(emp), HttpStatus.CREATED);
	}
	
	//build get all employee REST API 
	@GetMapping()
	public List<Employee> listEmployeeDetails(){
		
		return employeeService.getEmployeeDetails();
	}
	
	
	//build get employee by id REST API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeebyID(@PathVariable("id") long id)
	{
		return new ResponseEntity<Employee>(employeeService.getEmployeeByID(id), HttpStatus.OK);
	}
	
	//build update employee REST API
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id")Long id,@RequestBody Employee emp)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(emp, id), HttpStatus.OK);
	}
	
	//build delete employee REST API
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>("Deleted successfully", HttpStatus.OK);
	}

}
