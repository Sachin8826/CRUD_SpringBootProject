package com.first.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.crud.entity.Employee;
import com.first.crud.service.EmployeeService;
import com.first.crud.service.impl.EmplloyeeServiceImpl;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

//	private EmployeeService employeeService;
//
//	public EmployeeController(EmployeeService employeeService) {
//		super();
//		this.employeeService = employeeService;
//	}

	@Autowired
	EmployeeService employeeService;

//	@PostMapping
//	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
//		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
//	}

	@PostMapping
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		Employee employee2 = new Employee();
		employee2 = employeeService.saveEmployee(employee);
		return new ResponseEntity<Employee>(employee2, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getById(@PathVariable long id) {
		return new ResponseEntity<Employee>(employeeService.getById(id), HttpStatus.OK);
	}
	
//	// by name
//	@GetMapping("{name}")
//	public ResponseEntity<Employee> getByName(@PathVariable String name) {
//		return new ResponseEntity<Employee>(employeeService.getByName(name), HttpStatus.OK);
//	}

	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted successfully ! ", HttpStatus.OK);
	}
}
