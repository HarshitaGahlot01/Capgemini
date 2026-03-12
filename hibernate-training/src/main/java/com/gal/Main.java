package com.gal;

import java.util.List;

import org.hibernate.Hibernate;

import com.gal.model.Batch;
import com.gal.model.TopicTeaching;
import com.gal.model.Trainee;
import com.gal.model.Trainer;

import jakarta.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {

        EntityManager em = null;

        try {

            em = EntityManagerFactoryProvider.getEntityManager();
            em.getTransaction().begin();

            // Fetch Batch from database
            Batch b1 = em.find(Batch.class, 1);   // Correct ID

            if (b1 != null) {

                // Lazy collection
                List<TopicTeaching> topicsTaught = b1.getTopicsTaught();

                // Initialize lazy collection
                Hibernate.initialize(topicsTaught);

                System.out.println("Topics Taught:");
                System.out.println(topicsTaught);

            } else {
                System.out.println("Batch not found in database");
            }

            em.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();

            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

        } finally {

            if (em != null) {
                em.close();
            }

            EntityManagerFactoryProvider.closeConnections();
        }
    }
}