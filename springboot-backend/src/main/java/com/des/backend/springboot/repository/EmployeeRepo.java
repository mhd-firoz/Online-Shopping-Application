package com.des.backend.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.des.backend.springboot.model.Employee;
/*
 * SimpleRepository has @Repository annotaion and that is implementation of Jpa Respository
 */

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
