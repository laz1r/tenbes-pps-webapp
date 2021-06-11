package com.tenbes.repository;

//import java.sql.Date;
import java.util.Date;
import java.sql.Time;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tenbes.entity.Schedule;
import com.tenbes.entity.User;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long>{

	/* Find one match only
	@Query("SELECT S FROM Schedule S Where S.date = ?1 AND S.time = ?2")
	Optional<Schedule> findScheduleByDandT(Date date, Time time);
	*/
	
	// find optional<schedule> by date and time
	@Query("SELECT S FROM Schedule S Where S.date = ?1 AND S.startTime = ?2") // HOW to return many schedules ??
	Optional<List<Schedule>> findScheduleByDandT(Date date, Time st);
	
	// find schedule by date,time, and client id
	@Query("SELECT S FROM Schedule S Where date = ?1 AND startTime = ?2 AND clientId = ?3")
	List<Schedule> findScheduleByDateTimeAndClientId(Date date, Time st, Integer clientId);
	
	// find schedule by client id
	@Query("SELECT S FROM Schedule S Where id = ?1")
	List<Schedule> findScheduleByClientId(Integer id);
	
	// find schedule by date and client id
	@Query("SELECT S FROM Schedule S Where date = ?1 AND clientId = ?2")
	List<Schedule> findScheduleByDateAndClientId(Date date, Integer id);
	
	// find schedule by date and time
	@Query("SELECT S FROM Schedule S Where date = ?1 AND startTime = ?2")
	List<Schedule> findScheduleByDateAndTime(Date date, Time st);
	
	//find schedule by datetime
	@Query("SELECT S FROM Schedule S Where datetime = ?1")
	List<Schedule> findScheduleByDT(OffsetDateTime datetime);
	
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Schedule Where id = ?1")
	void deleteScheduleByIntId(Integer id);
	
	
}