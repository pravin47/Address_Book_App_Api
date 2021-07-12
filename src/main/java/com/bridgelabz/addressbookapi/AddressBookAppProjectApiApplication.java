package com.bridgelabz.addressbookapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressBookAppProjectApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookAppProjectApiApplication.class, args);
		//log.info("Address Book App Started {} Environment ", context.getEnvironment().getProperty("environment"));
		//log.info("Address Book DB User is {} ", context.getEnvironment().getProperty("spring.datasource.username"));
	
	}

}