package com.m2i.muni.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.muni.model.Channel;
import com.m2i.muni.repository.ChannelRepository;

@Service
public class ChannelDirectory {
	
	@Autowired
	private ChannelRepository channelRepository;
	
	public void addChannel(Channel newChannel) {
		channelRepository.save(newChannel);
	}
	
	public List<Channel> getChannels(){
		return channelRepository.findAll();
	}
	
	public Optional<Channel> getChannelById(Long id){
		return channelRepository.findById(id);
	}
	
	public void deleteChannel(Long id) {
		channelRepository.deleteById(id);
	}
	
	public void updateChannel(Channel channel, Long id) {
		channelRepository.save(channel);
	}

}
