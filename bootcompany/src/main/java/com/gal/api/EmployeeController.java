package com.gal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gal.model.Department;
import com.gal.model.Employee;
import com.gal.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // URL → http://localhost:8085/employees/101
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.find(id);
    }
    @GetMapping("/employee/byname")
    public Employee getEmployeeByName(@RequestParam("name") String name) {
        Employee e= employeeService.findByFirstName(name);
        return e;
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    			public Employee addEmployee(@RequestBody Employee employee) {
			employeeService.add(employee);
			return employee;
		}
    			@PutMapping(consumes = "application/json", produces = "application/json")
				public Employee updateEmployee(@RequestBody Employee employee) {
					return employeeService.update(employee);
				}
}
