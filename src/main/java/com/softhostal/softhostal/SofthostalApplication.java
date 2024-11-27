package com.softhostal.softhostal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//para desplegar eliminar el puerto de despliegue en properties y modificar el el archivo pom.xml se deb crear el archivo en el
@SpringBootApplication
public class SofthostalApplication {
	public static void main(String[] args) {
		SpringApplication.run(SofthostalApplication.class, args);
	}

}
