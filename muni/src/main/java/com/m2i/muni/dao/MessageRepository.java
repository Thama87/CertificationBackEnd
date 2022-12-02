package com.m2i.muni.dao;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2i.muni.model.Message;




@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
	//List<Message> findByStartDateBefore(LocalDateTime postDate);
	List<Message> findByPostTimeBefore(LocalDateTime postTime);
}