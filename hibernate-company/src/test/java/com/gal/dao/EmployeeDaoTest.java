package com.gal.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.gal.EntityManagerFactoryProvider;
import com.gal.model.Employee;

class EmployeeDaoTest {

    static EmployeeDao dao;

    @BeforeAll
    public static void openConnections() {
        System.out.println("opening connections");
        EntityManagerFactoryProvider.getEntityManager();
        dao = new EmployeeDao();
    }

    @Test
    void testGetEmployee() {

        Employee employee = dao.getEmployee(208);

        assertNotNull(employee);

        System.out.println(employee);

        assertEquals("Aditya", employee.getFirst_name());
    }

    @Test
    void testUpdateEmployee() {

        Date hire_date = Date.valueOf("2020-04-05");

        Employee emp = new Employee(
                hire_date,
                3000.0,
                208,
                200,
                20,
                "98655421",
                "Aditya",
                "Kumar Sharma",
                "aditya@gmail.com",
                "SW Developer"
        );

        dao.updateEmployee(emp);

        assertNotNull(emp);

        System.out.println(emp);
    }

    @AfterAll
    public static void closeConnection() {

        System.out.println("closing connections");

        EntityManagerFactoryProvider.getEntityManager().close();
        EntityManagerFactoryProvider.getEntityManagerFactory().close();
    }
}