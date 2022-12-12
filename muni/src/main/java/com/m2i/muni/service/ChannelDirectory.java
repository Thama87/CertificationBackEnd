package com.m2i.muni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.muni.dao.ChannelRepository;
import com.m2i.muni.model.Channel;

@Service
public class ChannelDirectory {

	// @Autowired permet d'activer l'injection automatique de dépendances
	@Autowired
	private ChannelRepository channelRepository;


	// Appel des méthodes déclarées dans ChannelRepository qui seront appelées dans ChannelController
	public List<Channel> getAllChannels(){
		return channelRepository.findAll();
	}

	public Optional<Channel> getChannelById(Long id){
		return channelRepository.findById(id);
	}


	public void addChannel(Channel newChannel) {
		channelRepository.save(newChannel);
	}


	public void deleteChannel(Long id) {
		channelRepository.deleteById(id);
	}


	public void updateChannel(Channel channel, Long id) {
		channelRepository.save(channel);
	}
}
