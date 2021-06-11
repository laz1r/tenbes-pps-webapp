package com.tenbes.entity;

import java.util.Date;


//import java.sql.Date; // ERROR becuase of using sql should use util ???
import java.sql.Time;
//import java.time.OffsetDateTime;
import java.time.OffsetDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo (generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name="schedule")
//@NamedQuery(name= "Schedule.deleteByDateAndTime",
	//		query = "DELETE FROM Schedule Where date = ?1 AND time = ?2")
public class Schedule {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="datetime")
	private OffsetDateTime datetime;
	
	@Column(name="date") // check output!, UTC ?
	private Date date;
	
	@Column(name="start_time") // check output!, UTC?
	private Time startTime; 
	
	@Column(name="end_time")
	private Time endTime;
	
	@Column(name="seconds_programming")
	private Long secondsProgramming;
	
	@Column(name="client_id")
	private Integer clientId;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne //(cascade=CascadeType.ALL) // user_id not posting in DB !
	@JoinColumn(name="user_id") 
	private User user;         // sending Integer to User object !
							   // ** NEED to send user object from FE 
							   // ** user object will have user_id
	
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	
	public OffsetDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(OffsetDateTime datetime) {
		this.datetime = datetime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time st) {
		this.startTime = st;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Long getSecondsProgramming() {
		return secondsProgramming;
	}

	public void setSecondsProgramming(Long secondsProgramming) {
		this.secondsProgramming = secondsProgramming;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}