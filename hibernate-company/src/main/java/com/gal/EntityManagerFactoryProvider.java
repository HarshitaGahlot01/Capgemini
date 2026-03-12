package com.gal;

import java.sql.Date;
import java.util.List;

import com.gal.model.Department;
import com.gal.model.Employee;
import com.gal.model.Item;
import com.gal.model.Parking;
import com.gal.model.Project;
import com.gal.model.Quotation;
import com.gal.model.Vendor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

// singleton design pattern : emf : one , em : many 
public class EntityManagerFactoryProvider {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("company_db_pu");
        }
        System.out.println(emf);
        return emf;
    }

    public static EntityManager getEntityManager() {
        if (emf == null)
            getEntityManagerFactory();

        if (em == null || !em.isOpen())
            em = emf.createEntityManager();

        return em;
    }

    public static void closeConnections() {
        getEntityManager().close();
        getEntityManagerFactory().close();
    }

    public static void main(String[] args) {

        EntityManager em = getEntityManager();

        // ================= INSERT SAMPLE DATA =================
        em.getTransaction().begin();

        Item item = new Item(0, "electronics", "laptop", 120000.0);

        Parking p1 = new Parking(0, 0, "S001");
        Parking p2 = new Parking(0, 0, "S002");

        Vendor v1 = new Vendor(0, "GoodOne Enterprises");

        Quotation q = new Quotation();
        q.setQdate(Date.valueOf("2025-05-08"));
        q.setCost(650000.0);

        // persist entities (uncomment if needed)
        // em.persist(item);
        // em.persist(p1);
        // em.persist(p2);
        // em.persist(v1);
        // em.persist(q);

        em.getTransaction().commit();

        System.out.println(p1);
        System.out.println(p2);

        // ================= QUERY ALL EMPLOYEES =================
        Query query = em.createQuery("select e from Employee e");

        List<Employee> list = query.getResultList();

        for (Employee e : list) {
            System.out.println(e);
        }

        // ================= DEPARTMENT EMPLOYEES =================
        System.out.println();

        Department dep = em.find(Department.class, 10);

        if (dep != null) {
            List<Employee> employees = dep.getEmployees();

            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }

        // ================= EMPLOYEE INTERESTS =================
        Employee emp8 = em.find(Employee.class, 208);

        if (emp8 != null) {
            System.out.println(emp8.getInterests());
        }

        // ================= CREATE PROJECT =================
        em.getTransaction().begin();

        Project p = new Project();
        p.setClient("AI Project");
        em.persist(p);

        em.getTransaction().commit();

        // ================= FETCH PROJECT =================
        Project savedProject = em.find(Project.class, p.getProjectid());

        System.out.println("Employees on project " + savedProject.getProjectid());

        if (savedProject != null) {

            List<Employee> employees2 = savedProject.getEmployees();

            if (employees2 != null) {

                for (Employee e : employees2) {
                    System.out.println(e.getFirst_name());
                }

            } else {
                System.out.println("No employees assigned to this project");
            }
        } else {
            System.out.println("Project not found");
        }

        // ================= CLOSE CONNECTION =================
        closeConnections();
    }
}