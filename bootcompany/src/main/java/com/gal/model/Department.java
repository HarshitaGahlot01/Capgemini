package com.gal.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {

    @Id
    @Column(name = "department_id")
    int departmentId;

    @Column(name = "department_name")
    String departmentName;

    @Column(name = "manager_id")
    Integer managerId;

    @Column(name = "established_date")
    Date establishedDate;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Date getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    @Override
    public String toString() {
        return "Department [departmentId=" + departmentId +
                ", departmentName=" + departmentName +
                ", managerId=" + managerId +
                ", establishedDate=" + establishedDate + "]";
    }
}