//package com.gal.api;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.gal.dao.EmployeeRepository;
//import com.gal.model.EmployeeDTO;
//
//public class EmployeeTransportController {
//@Autowired
//EmployeeRepository repo;
//@RequestMapping("/employee")
//public List<EmployeeDTO> getEmployeeTransportDetails(){
//	return repo.findAll().stream().map(e->new EmployeeDTO(e)).collect(Collectors.toList());
//	
//}
//}
package com.gal.api;

import com.gal.model.Employee;
import com.gal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/transport")
public class EmployeeTransportController {

    @Autowired
    private EmployeeService employeeService;}

    // 🔥 GET by cab + date
//    @GetMapping("/cab-date")
//    public List<Employee> getEmployeesByCabAndDate(
//            @RequestParam String cabNumber,
//            @RequestParam String date) {
//
//        Date bookingDate = Date.valueOf(date); // format: yyyy-MM-dd
//        return employeeService.getEmployeesByCabAndDate(cabNumber, bookingDate);
//    }
//}