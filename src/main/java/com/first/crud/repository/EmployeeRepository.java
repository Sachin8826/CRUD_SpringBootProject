package com.first.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.first.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	Employee findByName(String name);

}
