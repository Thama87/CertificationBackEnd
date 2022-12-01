package com.m2i.muni.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2i.muni.model.User;




@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}