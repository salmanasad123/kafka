package com.demo.pure_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PureClientApplication {

	/**
	 * This is a Pure-client means it will access resource from another server by calling its Api.
	 * This is a demonstration of machine to machine communication. For example a reporting application
	 * accessing data from a task-service. Since this is a machine to machine communication, we will
	 * use client-credentials-flow.
	 * The resource server is a task-service and its endpoints/apis are protected so we will access it
	 * by using client-credentials-flow with OAuth2.
	 * A maven dependency is added in the pom file of this service which makes it as a OAuth2Client.
	 */

	public static void main(String[] args) {
		SpringApplication.run(PureClientApplication.class, args);
	}

}
