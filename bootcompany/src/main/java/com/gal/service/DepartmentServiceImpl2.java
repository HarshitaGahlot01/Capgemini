package com.gal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.gal.dao.DepartmentRepository;
import com.gal.model.Department;

import jakarta.transaction.Transactional;

@Service
@Primary
public class DepartmentServiceImpl2 implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department find(int departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    @Transactional
    public void add(Department department) {
        departmentRepository.save(department);
    }

    @Override
    @Transactional
    public void delete(int departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    @Transactional
    public Department update(Department department) {
        Optional<Department> op = departmentRepository.findById(department.getDepartmentId());

        if (op.isEmpty()) {
            throw new RuntimeException("Department not found");
        }

        return departmentRepository.save(department);
    }

  
    @Override
    public Department findByName(String name) {
        return departmentRepository.findByDepartmentName(name);
    }

    @Override
    public Department getLatestDepartment() {
        return departmentRepository.findLatestDepartment();
    }

    @Override
    public List<Department> getDepartmentsWithoutManager() {
        return departmentRepository.findDepartmentWithoutManager();
    }
}