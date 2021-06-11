package com.tenbes.controller;

//import java.sql.Date;
import java.util.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tenbes.entity.Schedule;
import com.tenbes.entity.User;
import com.tenbes.repository.ScheduleRepository;

@RestController
@CrossOrigin
public class ScheduleController {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	//create date and time schedule
	@RequestMapping(value="/addS",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST
			)
	public void createSchedule(@RequestBody Schedule schedule) {
		
		System.out.println("I AM CALLED!!!");
		this.scheduleRepository.save(schedule);
		
	}
	
	@RequestMapping(value="/delS",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST
			)
	public void deleteSchedule(@RequestBody Schedule schedule) { 
			
		//EntityManager.createQuery("DELETE FROM Schedule Where date = ?1 AND time = ?2").executeUpdate();
		
		// ** Find record based on date time and client_id
		//   2. Place returned object in a variable
		//   3. get the id of the schedule
		//   4. delete the schedule
		
		List<Schedule> s = this.scheduleRepository.findScheduleByDateTimeAndClientId(schedule.getDate(), schedule.getStartTime(), schedule.getClientId());
		
		for(int i = 0; i < s.size(); i++) {
			this.scheduleRepository.deleteScheduleByIntId(s.get(i).getId());
		}

		
	}
	
	// findSchedule1 = find other schedules by date and time
	// TODO: how to consume the json data on React side ?
	@RequestMapping(value="/findSchedule1",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST
			)
	public List<Schedule> findScheduleByDateAndTime(@RequestBody Schedule schedule){
		
		/* SHOULD i use optional here ??
		Optional<List<Schedule>> s = this.scheduleRepository.findScheduleByDateAndTime(date, time);
		Optional<List<Schedule>> p = Optional.empty(); // returns null
		
		if(s.isPresent()) {
			return s;
		}
		return p;
		*/
		
		List<Schedule> s = this.scheduleRepository.findScheduleByDateAndTime(schedule.getDate(), schedule.getStartTime());
		
		return s;

	}
	// find schedule by datetime
	@RequestMapping(value="/findSchedule2",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE,
			method=RequestMethod.POST
			)
	public List<Schedule> findScheduleByDateTime(@RequestBody Schedule schedule){
		
		List<Schedule> s = this.scheduleRepository.findScheduleByDT(schedule.getDatetime());
		
		return s;

	}
	
	@RequestMapping(value="/findAllSchedules",
				produces=MediaType.APPLICATION_JSON_VALUE,
				method=RequestMethod.GET
			)
	public List<Schedule> findAllSchedules() {
		return this.scheduleRepository.findAll();
	}
	
	// get seconds from database, display to timer on frontend
	
}