package com.m2i.muni.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Methodes {
	// Méthode qui permet de convertir l'url du format String vers le format LocalDateTime
	public static LocalDateTime stringToDate( String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
		return LocalDateTime.parse(dateString, formatter);
	}
}
