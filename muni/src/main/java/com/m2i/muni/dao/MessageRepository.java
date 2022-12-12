package com.m2i.muni.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2i.muni.model.Message;
import com.m2i.muni.model.User;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findByPostTimeBefore(LocalDateTime postTime);
	List<Message> findByPostTimeAfter(LocalDateTime postTime);
	List<Message> findByPostTimeBetween(LocalDateTime postTime1, LocalDateTime postTime2);

	List<Message> findByEditTimeBefore(LocalDateTime postTime);
	List<Message> findByEditTimeAfter(LocalDateTime postTime);
	List<Message> findByEditTimeBetween(LocalDateTime postTime1, LocalDateTime postTime2);
	List<Message> findByEditTimeNotNull();

	List<Message> findByContentContaining(String snippet);

	List<Message> findByUser(Optional<User> user);
}