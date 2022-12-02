package com.m2i.muni.controller;

import java.time.LocalDateTime;
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
import com.m2i.muni.service.MessageDirectory;

@RestController
@RequestMapping("api")
public class MessageController {
	
	@Autowired
	private MessageDirectory messageDirectory;
	
	@GetMapping("messages")
	public List<Message> getMessage() {
		return messageDirectory.getMessages();
	}
	
	@GetMapping("messages/{id}")
	public ResponseEntity<Message> getMessageById(@PathVariable("id") Long id) {
		Optional<Message> optionalMessage = messageDirectory.getMessageById(id);
		if (optionalMessage.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalMessage.get());
		}
	}
	
	@PostMapping("messages")
	public Message postMessage(@RequestBody Message newMessage) {
		messageDirectory.addMessage(newMessage);
		return newMessage;
	}
	
	@DeleteMapping("messages/{id}")
	public void deleteMessage(@PathVariable("id") Long id) {
		messageDirectory.deleteMessage(id);
	}
	
	@PutMapping("messages/{id}")
	public  ResponseEntity<Message> updateMessage(@RequestBody Message varMessage,  @PathVariable("id") Long id){
		if(!varMessage.getId().equals(id)) {
			return ResponseEntity.badRequest().build();
		}
		else {
			messageDirectory.updateMessage(varMessage, id);
			return ResponseEntity.ok().build();
		}
	}
	
	@GetMapping("messages/before/{date}")
	public List<Message> findByPostTimeBefore(@PathVariable("date")LocalDateTime postTime){
		return messageDirectory.findByPostTimeBefore(postTime);
	}

}
