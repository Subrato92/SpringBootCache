package com.scope.banking.repository;

import java.util.Optional;
import com.scope.banking.models.Book;

public interface BookRepository {
	Optional<Book> getByIsbn(String isbn);
	void addBook(Book bk);
	
}
