package com.spring.boot.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
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


}
