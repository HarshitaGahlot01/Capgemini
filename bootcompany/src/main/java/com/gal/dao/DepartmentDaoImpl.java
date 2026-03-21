package com.gal.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gal.model.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.transaction.Transactional;

@Component
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public Department find(int departmentId) {

        EntityManager em = emf.createEntityManager();
        Department department = em.find(Department.class, departmentId);

        return department;
    }

    @Override
    public List<Department> findAll() {

        EntityManager em = emf.createEntityManager();

        List<Department> departments =
                em.createQuery("from Department", Department.class)
                        .getResultList();

        return departments;
    }

    @Override
    @Transactional
    public void add(Department department) {

        EntityManager em = emf.createEntityManager();
        em.persist(department);
    }

    @Override
    @Transactional
    public void delete(int departmentId) {

        EntityManager em = emf.createEntityManager();

        Department department = em.find(Department.class, departmentId);

        if (department != null) {
            em.remove(department);
        }
    }

    @Override
    @Transactional
    public void update(Department department) {

        EntityManager em = emf.createEntityManager();
        em.merge(department);
    }
}