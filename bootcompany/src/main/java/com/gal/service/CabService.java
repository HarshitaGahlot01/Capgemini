package com.gal.service;

import java.util.List;

import com.gal.model.Cab;

public interface CabService {
    Cab addCab(Cab cab);
    List<Cab> getAllCabs();
    Cab getCabById(int id);
    Cab updateCab(int id, Cab cab);
    void deleteCab(int id);
}