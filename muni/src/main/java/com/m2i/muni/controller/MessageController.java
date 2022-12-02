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
	
	@Autowired
	private MessageDirectory messageDirectory;
	
	@GetMapping("messages")
	public List<Message> getAllMessages() {
		return messageDirectory.getAllMessages();
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
	
	@GetMapping("messages/postbefore/{date}")
	public List<Message> getMessagesPostBefore(@PathVariable("date") String dateString){
		return messageDirectory.getMessagesPostBefore(Methodes.stringToDate(dateString));
	}
	
	@GetMapping("messages/postafter/{date}")
	public List<Message> getMessagesPostAfter(@PathVariable("date") String dateString){
		return messageDirectory.getMessagesPostAfter(Methodes.stringToDate(dateString));
	}
	
	@GetMapping("messages/postbetween/{date1}/{date2}")
	public List<Message> getMessagesPostBetween(@PathVariable("date1") String postTime1, @PathVariable("date2") String postTime2){
		return messageDirectory.getMessagesPostBetween(Methodes.stringToDate(postTime1), Methodes.stringToDate(postTime2));
	}
	
	@GetMapping("messages/editbefore/{date}")
	public List<Message> getMessagesEditBefore(@PathVariable("date") String dateString){
		return messageDirectory.getMessagesEditBefore(Methodes.stringToDate(dateString));
	}
	
	@GetMapping("messages/editafter/{date}")
	public List<Message> getMessagesEditAfter(@PathVariable("date") String dateString){
		return messageDirectory.getMessagesEditAfter(Methodes.stringToDate(dateString));
	}
	
	@GetMapping("messages/editbetween/{date1}/{date2}")
	public List<Message> getMessagesEditBetween(@PathVariable("date1") String postTime1, @PathVariable("date2") String postTime2){
		return messageDirectory.getMessagesEditBetween(Methodes.stringToDate(postTime1), Methodes.stringToDate(postTime2));
	}
	
	@GetMapping("messages/contains/{snippet}")
	public List<Message> getMessagesContaining(@PathVariable("snippet") String snippet){
		return messageDirectory.getMessagesContaining(snippet);
	}
	
	@GetMapping("messages/modified")
	public List<Message> getModifiedMessages(){
		return messageDirectory.getModifiedMessages();
	}
	
	@GetMapping("messages/user/{id}")
	public List<Message> getMessagesByUserId(@PathVariable("id") Long id){
		return messageDirectory.getMessagesByUserId(id);
	}

}
