package com.abnig.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abnig.model.Employee;
import com.abnig.model.dao.service.EmployeeRepositoryService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepositoryService employeeRepositoryServiceImpl;  

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Employee greeting(@PathVariable(value = "id") Long id) {
		System.out.println("Recieved ID:" + id);
		return this.employeeRepositoryServiceImpl.findById(id);
	}
}