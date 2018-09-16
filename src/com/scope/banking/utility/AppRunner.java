package com.scope.banking.utility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.scope.banking.models.Book;
import com.scope.banking.repository.BookRepository;

@Component
public class AppRunner implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
	
	@Autowired
	private final BookRepository bkRepo;
	
	public AppRunner(BookRepository bkRepo){
		this.bkRepo = bkRepo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		bkRepo.addBook(new Book("isbn-1234", "Title1234"));
		bkRepo.addBook(new Book("isbn-4567", "Title4567"));
		
		logger.info(".... Fetching Books");
		
		//Cashing Data
		logger.info("isbn-1234 -->" + bkRepo.getByIsbn("isbn-1234"));
		logger.info("isbn-4567 -->" + bkRepo.getByIsbn("isbn-4567"));
		logger.info("isbn-1234 -->" + bkRepo.getByIsbn("isbn-1234"));
		logger.info("isbn-4567 -->" + bkRepo.getByIsbn("isbn-4567"));
		logger.info("isbn-1234 -->" + bkRepo.getByIsbn("isbn-1234"));
		logger.info("isbn-4567 -->" + bkRepo.getByIsbn("isbn-4567"));
		//evicting
		bkRepo.addBook(new Book("isbn-1234", "changed-Title1234"));
		bkRepo.addBook(new Book("isbn-4567", "changed-Title4567"));
		//Cashing
		logger.info("isbn-1234 -->" + bkRepo.getByIsbn("isbn-1234"));
		logger.info("isbn-4567 -->" + bkRepo.getByIsbn("isbn-4567"));
		logger.info("isbn-1234 -->" + bkRepo.getByIsbn("isbn-1234"));
		logger.info("isbn-4567 -->" + bkRepo.getByIsbn("isbn-4567"));
		logger.info("isbn-1234 -->" + bkRepo.getByIsbn("isbn-1234"));
		logger.info("isbn-4567 -->" + bkRepo.getByIsbn("isbn-4567"));
	}
	
}
