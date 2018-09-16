package com.scope.banking.utility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.scope.banking.*")
@EnableCaching
public class CashingDemo {
	public static void main(String[] args){
		SpringApplication.run(CashingDemo.class, args);
	}
}
