package com.mohamed.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamed.springboot.dao.EmployeeRepository;
import com.mohamed.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> theEmployee = repository.findById(id);

		if (theEmployee.isEmpty()) {
			throw new RuntimeException("Employee Not Found");
		}

		return theEmployee.get();

	}

	@Override
	public Employee save(Employee theEmployee) {
		return repository.save(theEmployee);
	}

	@Override
	public void deleteById(int id) {
		repository.deleteById(id);
	}

}
