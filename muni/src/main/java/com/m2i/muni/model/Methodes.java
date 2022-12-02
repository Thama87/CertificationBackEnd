package com.m2i.muni.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Methodes {
	public static LocalDateTime stringToDate( String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
		return LocalDateTime.parse(dateString, formatter);
	}

}
