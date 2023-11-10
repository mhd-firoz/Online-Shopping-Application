package com.des.backend.springboot.serviceimp;

import org.springframework.stereotype.Service;

import com.des.backend.springboot.model.Employee;
import com.des.backend.springboot.repository.EmployeeRepo;
import com.des.backend.springboot.service.EmployeeService;


@Service
public class ServiceImplimentation implements EmployeeService{
	
	private EmployeeRepo employeeRepo;
	
	//injection as constructor 

	public ServiceImplimentation(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepo.save(emp);
	}


	

}
