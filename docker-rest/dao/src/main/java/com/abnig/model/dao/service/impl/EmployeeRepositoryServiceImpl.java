package com.abnig.model.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.abnig.model.Employee;
import com.abnig.model.dao.EmployeeRepository;
import com.abnig.model.dao.service.EmployeeRepositoryService;

@Service("employeeRepositoryServiceImpl")
@Transactional(readOnly = true)
public class EmployeeRepositoryServiceImpl implements EmployeeRepositoryService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee findById(Long id) {
		return this.employeeRepository.findById(id).get();
	}

	public List<Employee> findAll() {
		return this.employeeRepository.findAll();
	}

	@Transactional(readOnly = false, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
	public Employee create(Employee employee) {
		return this.employeeRepository.save(employee);
	}

}
