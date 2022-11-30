package com.m2i.muni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.muni.model.User;
import com.m2i.muni.repository.UserRepository;

@Service
public class UserDirectory {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addClient(User newUser) {
		userRepository.save(newUser);
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(Long id){
		return userRepository.findById(id);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public void updateUser(User user, Long id) {
		userRepository.save(user);
	}

}
