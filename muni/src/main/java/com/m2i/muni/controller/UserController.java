package com.m2i.muni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.muni.model.User;
import com.m2i.muni.service.UserDirectory;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserDirectory userDirectory;
	
	@GetMapping("users")
	public List<User> getAllUsers() {
		return userDirectory.getAllUsers();
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		Optional<User> optionalUser = userDirectory.getUserById(id);
		if (optionalUser.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalUser.get());
		}
	}
	
	@PostMapping("users")
	public User postUser(@RequestBody User newUser) {
		userDirectory.addUser(newUser);
		return newUser;
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userDirectory.deleteUser(id);
	}
	
	@PutMapping("users/{id}")
	public  ResponseEntity<User> updateUser(@RequestBody User varUser,  @PathVariable("id") Long id){
		if(!varUser.getId().equals(id)) {
			return ResponseEntity.badRequest().build();
		}
		else {
			userDirectory.updateUser(varUser, id);
			return ResponseEntity.ok().build();
		}
	}

}
