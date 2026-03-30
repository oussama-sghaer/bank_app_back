package com.training.bank_app_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BankAppBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppBackApplication.class, args);
	}

}
