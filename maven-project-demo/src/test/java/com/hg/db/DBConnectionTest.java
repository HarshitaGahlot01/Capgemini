package com.hg.db;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DBConnectionTest {

    @Test   
    void getConnection() {

        Connection c = null;

        try {
            c = DBConnection.getConnection();
            System.out.println(c);

            assertNotNull(c); 

        } finally {

            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}