package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;

@RestController
@RequestMapping("/org")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	//add employee
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee emp)
	{
		return employeeService.insertEmployee(emp);
	}
	
	//get all Data
	
	@GetMapping("/employee")
	public List<Employee> getAllData()
	{
		return employeeService.getAllEmployee();
	}
	
	//get employee by id 
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> getById(@PathVariable long id)
	{
		return employeeService.getByIdEmployee(id);
	}
	
	
	// update employee
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return employeeService.insertEmployee(emp);
		
	}
	//Delete employee
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		
		return "Deleted";
	}
	
}
