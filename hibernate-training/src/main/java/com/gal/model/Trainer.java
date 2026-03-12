package com.gal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // DB will have auto_increment in table
	long trainerid;
	@Column(unique = true)
	String capgtrainerid; // usually emailid, external generated id, software access contorl id
	@Column(nullable = false)
	String name;
	String company;
	String specialization;

	public long getTrainerid() {
		return trainerid;
	}

	public void setTrainerid(long trainerid) {
		this.trainerid = trainerid;
	}

	public String getCapgtrainerid() {
		return capgtrainerid;
	}

	public void setCapgtrainerid(String capgtrainerid) {
		this.capgtrainerid = capgtrainerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return "Trainer [trainerid=" + trainerid + ", capgtrainerid=" + capgtrainerid + ", name=" + name + ", company="
				+ company + ", specialization=" + specialization + "]";
	}

	public Trainer() {
		super();
	}

	public Trainer(String name, String company, String specialization) {
		super();
		this.name = name;
		this.company = company;
		this.specialization = specialization;
	}

}