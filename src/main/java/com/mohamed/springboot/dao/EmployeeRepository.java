package com.mohamed.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohamed.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
