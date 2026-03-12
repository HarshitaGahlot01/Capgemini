package com.gal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Trainee {

	@SequenceGenerator(name = "traineeseq", allocationSize = 1, initialValue = 1001, sequenceName = "traineeseq")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traineeseq")
	long superid;
	@Column(nullable = false)
	String name;
	String institute;
	String email;
	String phone;
	// trainee many to one batch
	@ManyToOne
	Batch batch; // batch_bid default

	public long getSuperid() {
		return superid;
	}

	public void setSuperid(long superid) {
		this.superid = superid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Trainee() {
		super();
	}

	public Trainee(String name, String institute, String email, String phone) {
		super();
		this.name = name;
		this.institute = institute;
		this.email = email;
		this.phone = phone;
	}

}