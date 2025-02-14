package com.spring.boot.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
public class SpringBootCourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCourseApplication.class, args);
		System.out.println("Application started...@");

	}

	// PlatformTransactionManager	==> interface

	@Bean
	public PlatformTransactionManager transactionManager(MongoDatabaseFactory factory){
		return new  MongoTransactionManager(factory);
	}
	// MongoTransactionManager		==> implementation class



	@Bean
	public RestTemplate restTemplate() throws IOException, URISyntaxException {
		return new RestTemplate();
	}

}
