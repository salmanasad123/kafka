package com.demo.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResourceApplication {

	/**
	 * This is a resource server as this contains the protected resources.The protected resource
	 * will be accessed by a client application.
	 * A maven dependency is added in the pom file of this service which makes it as a OAuth2ResourceServer.
	 * This is a demonstration of machine to machine communication. For example a reporting application
	 * accessing data from a task-service. Since this is a machine to machine communication, we will
	 * use client-credentials-flow.
	 */

	public static void main(String[] args) {
		SpringApplication.run(ResourceApplication.class, args);
	}

}
