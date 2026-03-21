package com.gal.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gal.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Department findByDepartmentName(String departmentName);

    // latest department
    @Query("SELECT d FROM Department d WHERE d.departmentId = (SELECT MAX(d2.departmentId) FROM Department d2)")
    Department findLatestDepartment();

    // no manager
    @Query("SELECT d FROM Department d WHERE d.managerId IS NULL")
    List<Department> findDepartmentWithoutManager();
}