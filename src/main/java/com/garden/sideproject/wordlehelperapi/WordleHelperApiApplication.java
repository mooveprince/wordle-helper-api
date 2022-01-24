package com.garden.sideproject.wordlehelperapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WordleHelperApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordleHelperApiApplication.class, args);
	}

}
