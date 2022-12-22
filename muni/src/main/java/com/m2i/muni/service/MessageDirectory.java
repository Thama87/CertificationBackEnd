package com.m2i.muni.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.muni.dao.ChannelRepository;
import com.m2i.muni.dao.MessageRepository;
import com.m2i.muni.dao.UserRepository;
import com.m2i.muni.model.Message;

@Service
public class MessageDirectory {

	// @Autowired permet d'activer l'injection automatique de dépendances
	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ChannelRepository channelRepository;


	// Appel des méthodes déclarées dans MessageRepository qui seront appelées dans MessageController
	public List<Message> getAllMessages() {
		return messageRepository.findAll();
	}

	public Optional<Message> getMessageById(Long id) {
		return messageRepository.findById(id);
	}


	public void addMessage(Message newMessage) {
		messageRepository.save(newMessage);
	}


	public void deleteMessage(Long id) {
		messageRepository.deleteById(id);
	}


	public void updateMessage(Message message, Long id) {
		messageRepository.save(message);
	}


	public List<Message> getMessagesPostBefore(LocalDateTime postTime) {
		return messageRepository.findByPostTimeBefore(postTime);
	}

	public List<Message> getMessagesPostAfter(LocalDateTime postTime) {
		return messageRepository.findByPostTimeAfter(postTime);
	}

	public List<Message> getMessagesPostBetween(LocalDateTime postTime1, LocalDateTime postTime2) {
		return messageRepository.findByPostTimeBetween(postTime1, postTime2);
	}


	public List<Message> getMessagesEditBefore(LocalDateTime postTime) {
		return messageRepository.findByEditTimeBefore(postTime);
	}

	public List<Message> getMessagesEditAfter(LocalDateTime postTime) {
		return messageRepository.findByEditTimeAfter(postTime);
	}

	public List<Message> getMessagesEditBetween(LocalDateTime postTime1, LocalDateTime postTime2) {
		return messageRepository.findByEditTimeBetween(postTime1, postTime2);
	}


	public List<Message> getMessagesContaining(String snippet) {
		return messageRepository.findByContentContaining(snippet);
	}


	public List<Message> getModifiedMessages() {
		return messageRepository.findByEditTimeNotNull();
	}


	public List<Message> getMessagesByUserId(Long id) {
		return messageRepository.findByUser(userRepository.findById(id));
	}


	public List<Message> getMessagesByChannelId(Long id) {
		return messageRepository.findByChannel(channelRepository.findById(id));
	}
}
