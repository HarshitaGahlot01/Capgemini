package com.gal.service;

import java.sql.Date;
import java.util.List;
import com.gal.model.Employee;

public interface EmployeeService {

    Employee find(int id);

    Employee findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    List<Employee> findAll();

    void add(Employee employee);

    void delete(int id);

    Employee update(Employee employee);
    
   // List<Employee> getEmployeesByCabAndDate(String cabNumber, Date bookingDate);
    }
