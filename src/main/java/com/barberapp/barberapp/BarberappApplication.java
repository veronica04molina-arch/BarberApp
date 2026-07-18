package com.barberapp.barberapp;

/*
 * Framework seleccionado: Spring Boot.
 * Se eligió porque facilita el desarrollo de aplicaciones web mediante una
 * arquitectura en capas, permite integrar PostgreSQL y desarrollar APIs
 * REST de forma rápida y organizada para el proyecto BarberApp.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarberappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarberappApplication.class, args);
	}

}
