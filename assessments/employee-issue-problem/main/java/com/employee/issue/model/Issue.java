package com.employee.issue.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private int issueId;

    @Column(name = "category")
    private String category;

    @Column(name = "raise_date")
    private LocalDate raiseDate;

    @Column(name = "resolve_date")
    private LocalDate resolveDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Issue() {}

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getRaiseDate() {
        return raiseDate;
    }

    public void setRaiseDate(LocalDate raiseDate) {
        this.raiseDate = raiseDate;
    }

    public LocalDate getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(LocalDate resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Issue [issueId=" + issueId + ", category=" + category +
               ", raiseDate=" + raiseDate + ", resolveDate=" + resolveDate +
               ", status=" + status + "]";
    }
}