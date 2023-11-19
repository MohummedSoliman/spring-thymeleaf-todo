package com.mohamed.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public List<Employee> findAll() {
		return service.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {

		Employee theEmployee = service.findById(employeeId);

		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		return theEmployee;
	}

	// add mapping for POST /employees - add new employee

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		theEmployee.setId(0);

		Employee dbEmployee = service.save(theEmployee);

		return dbEmployee;
	}

	// add mapping for PUT /employees - update existing employee

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {

		Employee dbEmployee = service.save(theEmployee);

		return dbEmployee;
	}

	// add mapping for DELETE /employees/{employeeId} - delete employee

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {

		Employee tempEmployee = service.findById(employeeId);

		// throw exception if null

		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}

		service.deleteById(employeeId);

		return "Deleted employee id - " + employeeId;
	}
}
