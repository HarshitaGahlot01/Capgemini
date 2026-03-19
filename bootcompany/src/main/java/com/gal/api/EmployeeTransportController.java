package com.gal.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gal.dao.EmployeeRepository;
import com.gal.model.EmployeeDTO;

public class EmployeeTransportController {
@Autowired
EmployeeRepository repo;
@RequestMapping("/employee")
public List<EmployeeDTO> getEmployeeTransportDetails(){
	return repo.findAll().stream().map(e->new EmployeeDTO(e)).collect(Collectors.toList());
	
}
}