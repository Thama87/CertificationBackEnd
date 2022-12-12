package com.m2i.muni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Classe liée à la table "users" de la base de données
@Entity
@Table(name = "users")
public class User {

	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Colonnes -----------------------------------------------//
	//-------------------------------------------------------------------------------------------------//

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;

	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Contructeurs -------------------------------------------//
	//-------------------------------------------------------------------------------------------------//

	public User() {}


	public User(String name) {
		this.name = name;
	}

	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Getters et Setters -------------------------------------//
	//-------------------------------------------------------------------------------------------------//

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//-------------------------------------------------------------------------------------------------//
	//---------------------------------------- Méthodes -----------------------------------------------//
	//-------------------------------------------------------------------------------------------------//

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
