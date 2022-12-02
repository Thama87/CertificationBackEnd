package com.m2i.muni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class MuniApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuniApplication.class, args);
	}

}
