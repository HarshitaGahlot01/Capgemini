package com.gal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gal.dao.EmployeeRepository;
import com.gal.model.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee find(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        Optional<Employee> op = employeeRepository.findById(employee.getEmployeeId());

        if (op.isEmpty()) {
            throw new RuntimeException("Employee not found");
        }

        return employeeRepository.save(employee);
    }

    @Override
    public Employee findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Override
    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }
}