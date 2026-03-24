package com.employee.issue.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.issue.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
