package com.m2i.muni.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

//Classe liée à la table "messages" de la base de données
@Entity
@Table(name = "messages")
public class Message {

	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Colonnes -----------------------------------------------//
	//-------------------------------------------------------------------------------------------------//

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "content", columnDefinition = "LONGTEXT")
	@Type(type = "text")
	private String content;
	@Column(name = "post_time")
	private LocalDateTime postTime;
	@Column(name = "edit_time")
	private LocalDateTime editTime;

	// Création d'une clé étrangère vers la table "users"
	@ManyToOne
	private User user;

	// Création d'une clé étrangère vers la table "channels"
	@ManyToOne
	private Channel channel;

	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Contructeurs -------------------------------------------//
	//-------------------------------------------------------------------------------------------------//

	public Message() {}


	public Message(String content, LocalDateTime postTime, LocalDateTime editTime) {
		this.content = content;
		this.postTime = postTime;
		this.editTime = editTime;
	}

	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Getters et Setters -------------------------------------//
	//-------------------------------------------------------------------------------------------------//

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	public LocalDateTime getPostTime() {
		return postTime;
	}
	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}


	public LocalDateTime getEditTime() {
		return editTime;
	}
	public void setEditTime(LocalDateTime editTime) {
		this.editTime = editTime;
	}

	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Méthodes -----------------------------------------------//
	//-------------------------------------------------------------------------------------------------//

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", postTime=" + postTime + ", editTime=" + editTime + "]";
	}
}
