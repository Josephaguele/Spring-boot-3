package com.example.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		var welcomeMessage = new WelcomeMessage();
		System.out.println(welcomeMessage.getWelcomeMessage());
	}

	public static class WelcomeMessage {

		public String getWelcomeMessage(){
			return "Welcome to the Spring Application";
		}
	}
}
