package com.employee.issue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.issue.model.Employee;
import com.employee.issue.service.IssueService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IssueService issueService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return issueService.addEmployee(employee);
    }
}