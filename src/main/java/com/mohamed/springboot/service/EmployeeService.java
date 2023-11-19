package com.mohamed.springboot.service;

import java.util.List;

import com.mohamed.springboot.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	Employee save(Employee theEmployee);

	void deleteById(int id);

}
