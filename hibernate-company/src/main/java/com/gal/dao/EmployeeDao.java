package com.gal.dao;

import com.gal.EntityManagerFactoryProvider;
import com.gal.model.Employee;

import jakarta.persistence.EntityManager;

public class EmployeeDao {

    public Employee getEmployee(int id) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();

        return em.find(Employee.class, id);
    }

    public void updateEmployee(Employee emp) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(emp);   // correct method for update

            em.getTransaction().commit();
        } 
        catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}