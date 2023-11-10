package com.des.backend.springboot.service;

import java.util.List;

import com.des.backend.springboot.model.Employee;


public interface EmployeeService {
	
/*
 * Save employee detail in database
 */
	Employee addEmployee(Employee emp);
	
/*
 * Retrive employee details from db
 */
	
	List<Employee> getEmployeeDetails();
	
	/*/
	 * Get employee by id
	 */
	
	Employee getEmployeeByID(long id);
	
	/*
	 * update employee
	 */

	Employee updateEmployee(Employee emp, long id);
	
	/*
	 * Delete Employee
	 */
	
	void deleteEmployee(long id);
}
