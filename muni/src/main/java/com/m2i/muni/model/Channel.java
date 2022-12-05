package com.m2i.muni.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//-------------------------------------------------------------------------------------------------//
//-----------------------Classe liée à la table "channels" de la base de données-------------------//
//-------------------------------------------------------------------------------------------------//
@Entity
@Table(name = "channels")
public class Channel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;

	// -------------------------------------------------------------------------------------------------//
	// -------------------------------------- Getters et Setters ---------------------------------------//
	// -------------------------------------------------------------------------------------------------//
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

	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	// -------------------------------------------------------------------------------------------------//
	// ---------------------------------------- Contructeurs
	// -------------------------------------------//
	// -------------------------------------------------------------------------------------------------//
	public Channel() {
	}

	public Channel(String name) {
		this.name = name;
	}

}
