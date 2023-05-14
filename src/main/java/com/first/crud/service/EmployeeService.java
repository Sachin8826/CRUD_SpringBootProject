package com.first.crud.service;

import java.util.List;

import com.first.crud.entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);

	List<Employee> getAll();

	Employee getById(long id);

	Employee updateEmployee(Employee employee, long id);

	void deleteEmployee(long id);
	
//	Employee getByName(String name);

}
