package com.mohamed.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohamed.springboot.entity.Employee;
import com.mohamed.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService service;
	
	@Autowired
	public EmployeeRestController(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return service.findAll();
	}
}
