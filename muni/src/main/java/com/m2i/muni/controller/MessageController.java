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

import com.m2i.muni.model.Message;
import com.m2i.muni.model.Methodes;
import com.m2i.muni.service.MessageDirectory;

@RestController
@RequestMapping("api")
public class MessageController {

	// @Autowired permet d'activer l'injection automatique de dépendances
	@Autowired
	private MessageDirectory messageDirectory;


	// Récupération de la liste de tous les messages
	@GetMapping("messages")
	public List<Message> getAllMessages() {
		return messageDirectory.getAllMessages();
	}

	// Récupération d'un message en fonction de son {id}.
	// Le cas d'un message non trouvé est traité
	@GetMapping("messages/{id}")
	public ResponseEntity<Message> getMessageById(@PathVariable("id") Long id) {
		Optional<Message> optionalMessage = messageDirectory.getMessageById(id);
		if (optionalMessage.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalMessage.get());
		}
	}


	// Ajout d'un nouveau message
	@PostMapping("messages")
	public void postMessage(@RequestBody Message newMessage) {
		messageDirectory.addMessage(newMessage);
	}


	// Suppression d'un message en fonction de son {id}
	// On vérifie que le message existe (en fonction de son id) avant la suppression
	@DeleteMapping("messages/{id}")
	public ResponseEntity<Message> deleteMessage(@RequestBody Message varMessage, @PathVariable("id") Long id) {
		if (!id.equals(varMessage.getId())) {
			return ResponseEntity.notFound().build();
		} else {
			messageDirectory.deleteMessage(id);
			return ResponseEntity.ok().build();
		}
	}


	// Modification d'un message
	// On vérifie que le message existe (en fonction de son id) avant la modification
	@PutMapping("messages/{id}")
	public ResponseEntity<Message> updateMessage(@RequestBody Message varMessage, @PathVariable("id") Long id) {
		if (!varMessage.getId().equals(id)) {
			return ResponseEntity.badRequest().build();
		} else {
			messageDirectory.updateMessage(varMessage, id);
			return ResponseEntity.ok().build();
		}
	}

	//-------------------------------------------------------------------------------------------------//
	//------------------------------------- Méthodes bonus --------------------------------------------//
	//-------------------------------------------------------------------------------------------------//

	// La méthode stringToDate permet de convertir l'url du format String vers le
	// format LocalDateTime
	// Affichage des messages postés avant {date}
	@GetMapping("messages/postbefore/{date}")
	public List<Message> getMessagesPostBefore(@PathVariable("date") String dateString) {
		return messageDirectory.getMessagesPostBefore(Methodes.stringToDate(dateString));
	}

	// Affichage des messages postés après {date}
	@GetMapping("messages/postafter/{date}")
	public List<Message> getMessagesPostAfter(@PathVariable("date") String dateString) {
		return messageDirectory.getMessagesPostAfter(Methodes.stringToDate(dateString));
	}

	// Affichage des messages postés entre {date1} et {date2}
	@GetMapping("messages/postbetween/{date1}/{date2}")
	public List<Message> getMessagesPostBetween(@PathVariable("date1") String postTime1,
			@PathVariable("date2") String postTime2) {
		return messageDirectory.getMessagesPostBetween(Methodes.stringToDate(postTime1),
				Methodes.stringToDate(postTime2));
	}


	// Affichage des messages modifiés avant {date}
	@GetMapping("messages/editbefore/{date}")
	public List<Message> getMessagesEditBefore(@PathVariable("date") String dateString) {
		return messageDirectory.getMessagesEditBefore(Methodes.stringToDate(dateString));
	}

	// Affichage des messages modifiés après {date}
	@GetMapping("messages/editafter/{date}")
	public List<Message> getMessagesEditAfter(@PathVariable("date") String dateString) {
		return messageDirectory.getMessagesEditAfter(Methodes.stringToDate(dateString));
	}

	// Affichage des messages modifiés entre {date1} et {date2}
	@GetMapping("messages/editbetween/{date1}/{date2}")
	public List<Message> getMessagesEditBetween(@PathVariable("date1") String postTime1,
			@PathVariable("date2") String postTime2) {
		return messageDirectory.getMessagesEditBetween(Methodes.stringToDate(postTime1),
				Methodes.stringToDate(postTime2));
	}


	// Affichage des messages contenant le texte {snippet}
	@GetMapping("messages/contains/{snippet}")
	public List<Message> getMessagesContaining(@PathVariable("snippet") String snippet) {
		return messageDirectory.getMessagesContaining(snippet);
	}


	// Affichage des messages ayant été modifiés
	@GetMapping("messages/modified")
	public List<Message> getModifiedMessages() {
		return messageDirectory.getModifiedMessages();
	}


	// Affichage de tous les messages de l'utilisateur d'identifiant {id}
	@GetMapping("messages/user/{id}")
	public List<Message> getMessagesByUserId(@PathVariable("id") Long id) {
		return messageDirectory.getMessagesByUserId(id);
	}
}
