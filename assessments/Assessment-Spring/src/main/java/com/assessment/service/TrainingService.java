package com.assessment.service;

import java.util.List;
import com.assessment.model.Training;

public interface TrainingService {

    Training find(int trainingId);

    Training findByName(String name);

    List<Training> findAll();

    List<Training> getTrainings();

    List<Training> searchTrainings(String name);

    List<Training> getUpcomingTrainings(String name);

    void add(Training training);

    void delete(int trainingId);

    void update(Training training);

}