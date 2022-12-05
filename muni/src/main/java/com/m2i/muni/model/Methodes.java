package com.m2i.muni.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Méthode qui permet de convertir l'url du format String vers le format LocalDateTime
public class Methodes {
	public static LocalDateTime stringToDate( String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
		return LocalDateTime.parse(dateString, formatter);
	}

}
