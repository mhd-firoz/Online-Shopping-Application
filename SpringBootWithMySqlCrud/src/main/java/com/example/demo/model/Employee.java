package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	
	//BirectionalMapping
	
	
	//Unidirectional 
	
	//OnetoOne mapping 
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval =true)
	@JoinColumn(name = "profile_id",referencedColumnName = "id")
	private Profile profile;
	
	
	//manytoOne
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id",referencedColumnName = "id")
	private Department department;

	


	//OneToMany
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id",referencedColumnName = "id")
	private List<Task> task;
	
	
	//manyTomany
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Project> project;
	
	
	public List<Task> getTask() {
		return task;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}
	public Employee() {
		super();
	}

	public Employee(long id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}	
	
	
	
	
}
