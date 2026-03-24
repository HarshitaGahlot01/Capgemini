package com.employee.issue.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.issue.model.Issue;
import com.employee.issue.model.Employee;
import com.employee.issue.repo.IssueRepository;
import com.employee.issue.repo.EmployeeRepository;

@Service
public class IssueServiceImplementation implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Issue> getUnresolvedIssuesByEmployee(int employeeId) {
        return issueRepository.findByEmployeeEmployeeIdAndStatus(employeeId, "OPEN");
    }

    @Override
    public List<Issue> getIssuesThisMonth() {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        LocalDate end = LocalDate.now();
        return issueRepository.findByRaiseDateBetween(start, end);
    }

    @Override
    public List<String> getEmployeeNamesThisMonth() {
        LocalDate start = LocalDate.now().withDayOfMonth(1);
        LocalDate end = LocalDate.now();
        return issueRepository.findEmployeeNamesThisMonth(start, end);
    }

  
    @Override
    public Issue addIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}