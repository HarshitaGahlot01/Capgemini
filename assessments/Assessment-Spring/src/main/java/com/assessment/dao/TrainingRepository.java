package com.assessment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.model.Training;

public interface TrainingRepository extends JpaRepository<Training, Integer> {

    // all trainings
    @Query("select t from Training t")
    List<Training> getAllTrainings();

    // search by topic
    @Query("select t from Training t where t.topic like %:name%")
    List<Training> findByName(@Param("name") String name);

    // upcoming trainings with topic
    @Query("select t from Training t where t.startDate > CURRENT_DATE and t.topic like %:name%")
    List<Training> getUpcomingTrainings(@Param("name") String name);
}