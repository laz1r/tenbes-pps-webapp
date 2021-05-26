package com.tenbes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.tenbes.repository.ScheduleRepository;

@RestController
@CrossOrigin
public class ScheduleController {
	
	@Autowired
	private ScheduleRepository scheduleRepository;
	
	//create date and time schedule
	
	// update date and time schedule
	
	// delete date and time schedule

}
