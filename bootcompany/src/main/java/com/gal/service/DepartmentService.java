package com.gal.service;

import java.util.List;
import com.gal.model.Department;

public interface DepartmentService {

    Department find(int departmentId);

    Department findByName(String name);

    Department getLatestDepartment();

    List<Department> getDepartmentsWithoutManager();

    List<Department> findAll();

    void add(Department department);

    void delete(int departmentId);

    Department update(Department department);
}