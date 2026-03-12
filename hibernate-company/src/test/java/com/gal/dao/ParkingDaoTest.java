package com.gal.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.gal.EntityManagerFactoryProvider;
import com.gal.model.Parking;

class ParkingDaoTest {

    @Test
    void testGetParking() {

        ParkingDao dao = new ParkingDao();

        Parking parking = dao.getParking(1);

        assertNotNull(parking);

        System.out.println(parking);
    }

    @Test
    void testaddParking() {

        ParkingDao dao = new ParkingDao();

        Parking obj = new Parking(0, 0, "A001");   // ID should be 0

        Parking parking = dao.addParking(obj);

        assertNotNull(parking);

        System.out.println(parking);
    }

    @BeforeAll
    public static void openConnections() {

        System.out.println("opening connections");

        EntityManagerFactoryProvider.getEntityManager();
    }

    @AfterAll
    public static void closeConnnection() {

        System.out.println("closing connections");

        EntityManagerFactoryProvider.getEntityManager().close();
        EntityManagerFactoryProvider.getEntityManagerFactory().close();
    }
}