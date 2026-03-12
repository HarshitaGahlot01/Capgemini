package com.gal.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class TopicTeaching {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long teachingid;
	@ManyToOne
	@JoinColumn(name = "trainerid")
	Trainer trainer;

	@ManyToOne
	@JoinColumn(name = "bid")
	Batch batch;

	Date stDate;
	Date endDate;
	String topics; // , separted single string

	public long getTeachingid() {
		return teachingid;
	}

	public void setTeachingid(long teachingid) {
		this.teachingid = teachingid;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Date getStDate() {
		return stDate;
	}

	public void setStDate(Date stDate) {
		this.stDate = stDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public TopicTeaching(long teachingid, Trainer trainer, Batch batch, Date stDate, Date endDate, String topics) {
		super();
		this.teachingid = teachingid;
		this.trainer = trainer;
		this.batch = batch;
		this.stDate = stDate;
		this.endDate = endDate;
		this.topics = topics;
	}

	public TopicTeaching(Trainer trainer, Batch batch, String topics) {
		super();
		this.trainer = trainer;
		this.batch = batch;
		this.topics = topics;
	}

	public TopicTeaching() {
		super();
	}

	@Override
	public String toString() {
		return "TopicTeaching [teachingid=" + teachingid + ", stDate=" + stDate + ", endDate=" + endDate + ", topics="
				+ topics + "]";
	}

}