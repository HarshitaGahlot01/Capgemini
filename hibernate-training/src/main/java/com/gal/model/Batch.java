package com.gal.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.TableGenerator;

@Entity
public class Batch {
	/*
	 * Teaching bid trainerid topics 1 101 sql, dsa 1 102 comm skills 1 105 java 2
	 * 101 sql 2 106 dsa
	 * 
	 */

	@TableGenerator(name = "batchidgenerator", allocationSize = 1, initialValue = 101, table = "allidgenerator", valueColumnName = "nextbatchid")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "batchidgenerator")
	long bid;
	String name;
	Date startDate;
	Date endDate;
	String content;
	String venue;
	@ManyToMany
	@JoinTable(name = "topicteaching", joinColumns = { @JoinColumn(name = "bid") }, inverseJoinColumns = {
			@JoinColumn(name = "trainerid") })
	List<Trainer> trainers = new ArrayList<>(); // control shift O

	@OneToMany(mappedBy = "batch")
	List<TopicTeaching> topicsTaught = new ArrayList<>();

	public long getBid() {
		return bid;
	}

	public void setBid(long bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public List<TopicTeaching> getTopicsTaught() {
		return topicsTaught;
	}

	public void setTopicsTaught(List<TopicTeaching> topicsTaught) {
		this.topicsTaught = topicsTaught;
	}

	public Batch() {
		super();
	}

	public Batch(String name, String content, String venue, List<TopicTeaching> topicsTaught) {
		super();
		this.name = name;
		this.content = content;
		this.venue = venue;
		this.topicsTaught = topicsTaught;
	}

//	Date : java.sql.Date 
//	datetime : java.util.Date 
//	date  LocalDate
//	time LocalTime

}