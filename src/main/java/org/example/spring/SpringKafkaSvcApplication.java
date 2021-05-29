package org.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class SpringKafkaSvcApplication {

	public static void main(String[] args) throws IOException {

		SpringApplication.run(SpringKafkaSvcApplication.class, args);

		/*String topicName = "spring-kafka-demo";

		FirstKafkaProducer firstKafkaProducer = new FirstKafkaProducer(topicName);

		firstKafkaProducer.send("key","message");

		firstKafkaProducer.close();*/
	}

}
