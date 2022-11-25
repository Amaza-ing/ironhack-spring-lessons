package com.ironhack.w3d5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class W3d5Application {
	public static void main(String[] args) {
		SpringApplication.run(W3d5Application.class, args);
	}

//	public static void main(String[] args) {
//		ApplicationContext applicationContext = SpringApplication.run(W3d5Application.class, args);
//		MyClass myClass = applicationContext.getBean(MyClass.class);
//
//		myClass.findAll();
//	}

}
