package com.gal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gal.model.Cab;
import com.gal.service.CabService;

@RestController
	@RequestMapping("/cab")
	public class CabController {

	    @Autowired
	    private CabService cabService;

	    @PostMapping
	    public Cab addCab(@RequestBody Cab cab) {
	        return cabService.addCab(cab);
	    }
	}
	

