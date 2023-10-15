package com.example.bookshopapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class BookShopAPIApplication {
	public static void main(String[] args) {
//		SpringApplication.run(BookShopAPiApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(BookShopAPIApplication.class, args);

		DatabaseConnectionTest connectionTest = context.getBean(DatabaseConnectionTest.class);
		connectionTest.testDatabaseConnection();

		// Đóng ứng dụng
		context.close();
	}
}
