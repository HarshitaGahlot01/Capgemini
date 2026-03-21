package com.gal.api;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gal.model.Employee;
import com.gal.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // GET by ID
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.find(id);
    }

    // GET by name
    @GetMapping("/byname")
    public Employee getEmployeeByName(@RequestParam("name") String name) {
        return employeeService.findByFirstName(name);
    }

    // POST
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.add(employee);
        return employee;
    }

    // PUT
    @PutMapping(consumes = "application/json", produces = "application/json")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }}
//    @GetMapping("/cab")
//    public List<Employee> getByCabAndDate(
//            @RequestParam String cabNumber,
//            @RequestParam Date bookingDate) {
//
//        return employeeService.getEmployeesByCabAndDate(cabNumber, bookingDate);
//    }
//}
