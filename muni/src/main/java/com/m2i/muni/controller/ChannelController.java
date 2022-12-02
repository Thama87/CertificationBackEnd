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

import com.m2i.muni.model.Channel;
import com.m2i.muni.service.ChannelDirectory;

@RestController
@RequestMapping("api")
public class ChannelController {
	
	@Autowired
	private ChannelDirectory channelDirectory;
	
	@GetMapping("channels")
	public List<Channel> getAllChannels() {
		return channelDirectory.getAllChannels();
	}
	
	@GetMapping("channels/{id}")
	public ResponseEntity<Channel> getChannelById(@PathVariable("id") Long id) {
		Optional<Channel> optionalChannel = channelDirectory.getChannelById(id);
		if (optionalChannel.isEmpty()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(optionalChannel.get());
		}
	}
	
	@PostMapping("channels")
	public Channel postChannel(@RequestBody Channel newChannel) {
		channelDirectory.addChannel(newChannel);
		return newChannel;
	}
	
	@DeleteMapping("channels/{id}")
	public void deleteChannel(@PathVariable("id") Long id) {
		channelDirectory.deleteChannel(id);
	}
	
	@PutMapping("channels/{id}")
	public  ResponseEntity<Channel> updateChannel(@RequestBody Channel varChannel,  @PathVariable("id") Long id){
		if(!varChannel.getId().equals(id)) {
			return ResponseEntity.badRequest().build();
		}
		else {
			channelDirectory.updateChannel(varChannel, id);
			return ResponseEntity.ok().build();
		}
	}

}
