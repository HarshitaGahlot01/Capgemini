package com.stream;
import java.util.List;
import java.util.Optional;

public class StreamApiAssignment {
	public static void main(String[] args) {
		List<Employee1> list=EmployeeRepository.getEmployees();
		List<Department> list2=EmployeeRepository.getDepartments();
		//sum of salary
		double totalSalary = EmployeeRepository.getEmployees()
		        .stream()
		        .mapToDouble(Employee1::getSalary)   // <-- use Employee1
		        .sum();

        System.out.println("Total Salary = " + totalSalary);
        //Senior most employee
        Optional <Employee1> s2=list.stream()
                .min((e1, e2) -> e1.getHireDate().compareTo(e2.getHireDate()));
        System.out.println(s2) ;   

}}
