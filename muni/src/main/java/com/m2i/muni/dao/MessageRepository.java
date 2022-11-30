package com.m2i.muni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2i.muni.model.Message;




@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}