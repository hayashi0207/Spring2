package com.example.demo.bookSearch;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	public Book findFId(int id) {
		Map<String,Object> map = bookRepository.findFId(id);
		
		int bookId = (Integer)map.get("book_id");
		String bookName = (String)map.get("book_name");
		int bookPublicationYear = (Integer)map.get("book_publication_year");
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setBookPublicationYear(bookPublicationYear);
		
		return book;
	}
	
	public Book findFName(String name) {
		
		Map<String,Object> map = bookRepository.findFName(name);
		
		int bookId = (Integer)map.get("book_id");
		String bookName = (String)map.get("book_name");
		int bookPublicationYear = (Integer)map.get("book_publication_year");
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setBookPublicationYear(bookPublicationYear);
		
		return book;
	}
	public Book findFPublicationYear(int publicationYear) {
		
		Map<String,Object> map = bookRepository.findFPublicationYear(publicationYear);
		
		int bookId = (Integer)map.get("book_id");
		String bookName = (String)map.get("book_name");
		int bookPublicationYear = (Integer)map.get("book_publication_year");
		
		Book book = new Book();
		book.setBookId(bookId);
		book.setBookName(bookName);
		book.setBookPublicationYear(bookPublicationYear);
		
		return book;
	}
}
