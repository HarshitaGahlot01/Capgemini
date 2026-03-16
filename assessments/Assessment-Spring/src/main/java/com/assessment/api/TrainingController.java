package com.assessment.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.model.Training;
import com.assessment.service.TrainingService;

@RestController
public class TrainingController {

    @Autowired
    TrainingService service;

    // URL → http://localhost:8085/trainings
    // URL → http://localhost:8085/trainings?name=spring
    @GetMapping("/trainings")
    public List<Training> getTrainings(@RequestParam(required = false) String name) {

        if (name == null) {
            return service.getTrainings();
        }

        return service.searchTrainings(name);
    }

    // URL → http://localhost:8085/trainings/upcoming?name=spring
    @GetMapping("/trainings/upcoming")
    public List<Training> getUpcoming(@RequestParam String name) {
        return service.getUpcomingTrainings(name);
    }
}