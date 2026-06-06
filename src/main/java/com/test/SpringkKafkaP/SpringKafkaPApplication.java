package com.test.SpringkKafkaP;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.Instant;

@SpringBootApplication
public class SpringKafkaPApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaPApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (KafkaTemplate<String,String> kafkaTemplate){
		return args -> {
			for (int i = 0; i < 10; i++) {
				kafkaTemplate.send("firstTopic","Hello Kafka " + Instant.now());
			}
		};
	}

}
