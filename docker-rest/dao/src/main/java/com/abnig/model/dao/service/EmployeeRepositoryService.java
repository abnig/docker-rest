package com.abnig.model.dao.service;

import java.util.List;

import com.abnig.model.Employee;

public interface EmployeeRepositoryService {
	
	public Employee findById(Long id);

	public List<Employee> findAll();

	public Employee create(Employee employee);
}
