package com.casestudy.amadeus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.casestudy.amadeus.*"})
public class AmadeusApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmadeusApplication.class, args);
	}

}
