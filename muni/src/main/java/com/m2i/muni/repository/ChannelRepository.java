package com.m2i.muni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2i.muni.model.Channel;




@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
}