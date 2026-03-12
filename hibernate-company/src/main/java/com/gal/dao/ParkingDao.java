package com.gal.dao;

import com.gal.EntityManagerFactoryProvider;
import com.gal.model.Parking;

import jakarta.persistence.EntityManager;

public class ParkingDao {

    public Parking getParking(int id) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();

        return em.find(Parking.class, id);
    }

    public Parking addParking(Parking parking) {

        EntityManager em = EntityManagerFactoryProvider.getEntityManager();

        em.getTransaction().begin();

        em.persist(parking);

        em.getTransaction().commit();

        return parking;
    }
}