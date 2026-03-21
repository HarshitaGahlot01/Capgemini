package com.gal.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gal.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // find by first name
//   Employee findByFirstName(String firstName);
////
////    // find by last name
//  List<Employee> findByLastName(String lastName);
////	List<Employee> findByCabNumberAndBookingDate(String cabNumber, Date bookingDate);
}