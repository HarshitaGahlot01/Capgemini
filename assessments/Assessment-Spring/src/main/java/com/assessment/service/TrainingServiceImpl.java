package com.assessment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.assessment.dao.TrainingRepository;
import com.assessment.model.Training;

import jakarta.transaction.Transactional;

@Service
@Primary
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    @Override
    public Training find(int trainingId) {

        Optional<Training> op = trainingRepository.findById(trainingId);
        return op.orElseThrow();
    }

    @Override
    public List<Training> findAll() {
        return trainingRepository.findAll();
    }

    // get all trainings
    public List<Training> getTrainings() {
        return trainingRepository.getAllTrainings();
    }

    // search by name
    public List<Training> searchTrainings(String name) {
        return trainingRepository.findByName(name);
    }

    // upcoming trainings
    public List<Training> getUpcomingTrainings(String name) {
        return trainingRepository.getUpcomingTrainings(name);
    }

    @Override
    @Transactional
    public void add(Training training) {
        trainingRepository.save(training);
    }

    @Override
    @Transactional
    public void delete(int trainingId) {
        trainingRepository.deleteById(trainingId);
    }

    @Override
    @Transactional
    public void update(Training training) {
        trainingRepository.save(training);
    }
    @Override
    public Training findByName(String name) {

        List<Training> trainings = trainingRepository.findByName(name);

        if(trainings.isEmpty()) {
            throw new RuntimeException("Training not found");
        }

        return trainings.get(0);
    }
}