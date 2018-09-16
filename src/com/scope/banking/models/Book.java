package com.scope.banking.models;

public class Book {
	private String isbn;
	private String title;
	
	public Book(String isbn, String title){
		this.isbn = isbn;
		this.title = title;
	}
	
	@Override
	public String toString(){
		return "Book{ isbn=" + isbn +", Title="+ title + "}";
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
