package com.des.backend.springboot.serviceimp;

import java.util.List;
import java.util.Optional;

import javax.xml.xpath.XPathEvaluationResult.XPathResultType;

import org.springframework.stereotype.Service;

import com.des.backend.springboot.exception.ResourceNotFoundException;
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

	@Override
	public List<Employee> getEmployeeDetails() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeByID(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepo.findById(id);
		
		if(employee.isPresent())
		{
			return employee.get();
		}
		else {
			
			throw new ResourceNotFoundException("Employee","Id", id);
		}
	
		/*
		 * Lambda expression - way of implementation return
		 * employeeRepo.findById(id).orElseThrow(()-> new
		 * ResourceNotFoundException("Employee", "Id", id));
		 */
	}

	@Override
	public Employee updateEmployee(Employee emp, long id) {
		// TODO Auto-generated method stub
		//We need to check whether employee with given id is exit in DB or not 
		/*
		 * Optional<Employee> existinEmp = employeeRepo.findById(id);
		 * 
		 * if(existinEmp.isPresent()) {
		 * 
		 * emp.setFirstName(null); return employeeRepo.save(emp); } else { throw new
		 * ResourceNotFoundException("Employee", "Id", id); }
		 */
		
		Employee existingEmployee =employeeRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(emp.getFirstName());
		existingEmployee.setLastName(emp.getLastName());
		existingEmployee.setEmail(emp.getEmail());
		
		employeeRepo.save(existingEmployee);
		
		return existingEmployee;
		
	}

	@Override
	public void deleteEmployee(long id) {
		
		//check whether a employee exist in DB or not 
		
		Optional<Employee> presentEmployee = employeeRepo.findById(id);
		
		if(presentEmployee.isPresent())
		{
			employeeRepo.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Employee", "Id",id);
		}
		
	}


	

}
