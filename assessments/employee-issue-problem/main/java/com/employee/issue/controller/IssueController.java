package com.employee.issue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.employee.issue.model.Issue;
import com.employee.issue.service.IssueService;

@RestController
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    // GET APIs
    @GetMapping("/unresolved/{empId}")
    public List<Issue> getUnresolvedIssues(@PathVariable int empId) {
        return issueService.getUnresolvedIssuesByEmployee(empId);
    }

    @GetMapping("/this-month")
    public List<Issue> getIssuesThisMonth() {
        return issueService.getIssuesThisMonth();
    }
    @GetMapping("/employee-names")
    public List<String> getEmployeeNamesThisMonth() {
        return issueService.getEmployeeNamesThisMonth();
    }

    @PostMapping("/add")
    public Issue addIssue(@RequestBody Issue issue) {
        return issueService.addIssue(issue);
    }
}