package com.meritamerica.assignment5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MeritAmericaBankApplication {

	public static void main(String[] args) {
		
		/* This run method starts up the Tomcat server, and compiles your 
		project down to a jar file, then deploys it to the Tomcat  */
		SpringApplication.run(MeritAmericaBankApplication.class, args);
		
	}

}
