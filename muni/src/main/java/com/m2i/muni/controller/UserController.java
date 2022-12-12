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

	// @Autowired permet d'activer l'injection automatique de dépendances
	@Autowired
	private UserDirectory userDirectory;


	// Récupération de la liste de tous les users
	@GetMapping("users")
	public List<User> getAllUsers() {
		return userDirectory.getAllUsers();
	}

	// Récupération d'un user en fonction de son {id}
	// Le cas d'un message non trouvé est traité
	@GetMapping("users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		Optional<User> optionalUser = userDirectory.getUserById(id);
		if (optionalUser.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalUser.get());
		}
	}


	// Ajout d'un nouveau user
	@PostMapping("users")
	public User postUser(@RequestBody User newUser) {
		userDirectory.addUser(newUser);
		return newUser;
	}


	// Suppression d'un user en fonction de son {id}
	// On vérifie que le user existe (en fonction de son id) avant la suppression
	@DeleteMapping("users/{id}")
	public ResponseEntity<User> deleteUser(@RequestBody User varUser, @PathVariable("id") Long id) {
		if (!id.equals(varUser.getId())) {
			return ResponseEntity.notFound().build();
		} else {
			userDirectory.deleteUser(id);
			return ResponseEntity.ok().build();
		}
	}


	// Modification d'un user
	// On vérifie que le user existe (en fonction de son id) avant la modification
	@PutMapping("users/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User varUser, @PathVariable("id") Long id) {
		if (!varUser.getId().equals(id)) {
			return ResponseEntity.badRequest().build();
		} else {
			userDirectory.updateUser(varUser, id);
			return ResponseEntity.ok().build();
		}
	}
}
