package com.scope.banking.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.scope.banking.models.Book;

@Component
public class SimpleBookRepository implements BookRepository {
	
	private List<Book> bkLst = new ArrayList<Book>();
	
	@Override
	//Reference of cache is books
	@Cacheable("books")
	public Optional<Book> getByIsbn(String isbn){
		simulateSlowService();
		//return new Book(isbn, "Some Book");
		return this.bkLst.stream().filter(obj->obj.getIsbn().equals(isbn)).findFirst();
	}
	
	@CacheEvict("books")
	public void addBook( Book bk ){
		bkLst.add(bk);
	}
	
	
	private void simulateSlowService(){
		try{
			long time = 3000L;
			Thread.sleep(time);
		}catch(InterruptedException e){
			throw new IllegalStateException(e);
		}
	}
}
