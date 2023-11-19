package com.mohamed.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mohamed.springboot.entity.Employee;
import com.mohamed.springboot.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService service;
	
	@Autowired
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> employees = service.findAll();
		theModel.addAttribute("employees", employees);
		return "list-employees";
	}
}
