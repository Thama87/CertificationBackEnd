package com.m2i.muni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.muni.dao.MessageRepository;
import com.m2i.muni.model.Message;

@Service
public class MessageDirectory {
	
	@Autowired
	private MessageRepository messageRepository;
	
	public void addMessage(Message newMessage) {
		messageRepository.save(newMessage);
	}
	
	public List<Message> getMessages(){
		return messageRepository.findAll();
	}
	
	public Optional<Message> getMessageById(Long id){
		return messageRepository.findById(id);
	}
	
	public void deleteMessage(Long id) {
		messageRepository.deleteById(id);
	}
	
	public void updateMessage(Message message, Long id) {
		messageRepository.save(message);
	}

}
