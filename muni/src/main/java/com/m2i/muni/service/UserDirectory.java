package com.m2i.muni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.muni.dao.UserRepository;
import com.m2i.muni.model.User;

@Service
public class UserDirectory {

	// @Autowired permet d'activer l'injection automatique de dépendance
	@Autowired
	private UserRepository userRepository;

	// Appel des méthodes déclarées dans UserRepository qui seront appelées dans UserController
	public void addUser(User newUser) {
		userRepository.save(newUser);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public void updateUser(User user, Long id) {
		userRepository.save(user);
	}

}
