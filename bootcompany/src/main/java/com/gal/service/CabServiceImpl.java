package com.gal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gal.dao.CabRepo;
import com.gal.model.Cab;

@Service
public class CabServiceImpl implements CabService {

    @Autowired
    private CabRepo cabRepo;

    // Add cab
    @Override
    public Cab addCab(Cab cab) {
        return cabRepo.save(cab);
    }

    // Get all cabs
    @Override
    public List<Cab> getAllCabs() {
        return cabRepo.findAll();
    }

    // Get cab by ID
    @Override
    public Cab getCabById(int id) {
        return cabRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cab not found with ID: " + id));
    }

    // Update cab
    @Override
    public Cab updateCab(int id, Cab cab) {
        Cab existingCab = cabRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cab not found with ID: " + id));

        existingCab.setRegno(cab.getRegno());
        existingCab.setModel(cab.getModel());
        existingCab.setCapacity(cab.getCapacity());

        return cabRepo.save(existingCab);
    }

    // Delete cab
    @Override
    public void deleteCab(int id) {
        Cab existingCab = cabRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cab not found with ID: " + id));

        cabRepo.delete(existingCab);
    }
}