package com.employee.issue.service;

import java.util.List;
import com.employee.issue.model.Issue;
import com.employee.issue.model.Employee;

public interface IssueService {

    List<Issue> getUnresolvedIssuesByEmployee(int employeeId);
    List<Issue> getIssuesThisMonth();
    List<String> getEmployeeNamesThisMonth();
    Issue addIssue(Issue issue);
    Employee addEmployee(Employee employee);
}