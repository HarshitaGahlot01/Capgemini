package com.employee.issue.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.employee.issue.model.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer> {
    List<Issue> findByEmployeeEmployeeIdAndStatus(int employeeId, String status);
 
    List<Issue> findByRaiseDateBetween(LocalDate start, LocalDate end);
   
    @Query("SELECT DISTINCT i.employee.employeeName FROM Issue i WHERE i.raiseDate BETWEEN :start AND :end")
    List<String> findEmployeeNamesThisMonth(LocalDate start, LocalDate end);

}