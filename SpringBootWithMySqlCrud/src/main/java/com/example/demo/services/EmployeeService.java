package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	//insert employee
	public Employee insertEmployee(Employee emp)
	{
		return employeeRepo.save(emp);
	}
	
	//Get all employee
	
	public List<Employee> getAllEmployee(){
		return employeeRepo.findAll();
	}
	
	//Get employee by id
	
	
	public Optional<Employee> getByIdEmployee(long id)
	{

		return employeeRepo.findById(id);
	}
	
	public void deleteEmployeeById(long id)
	{
		employeeRepo.deleteById(id);
	}
	
	

}
