package com.example.demo.bookSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	@PostMapping("/search/db/fromId")
	public String postSearchFId(@RequestParam("bookId")String str,Model model) {
		int id = Integer.parseInt(str);
		
		Book book = bookService.findFId(id);
		
		model.addAttribute("id",book.getBookId());
		model.addAttribute("name",book.getBookName());
		model.addAttribute("publication_year",book.getBookPublicationYear());
		
		return "searchResult";
	}
	
	@PostMapping("/search/db/fromName")
	public String postSearchFName(@RequestParam("bookName")String str,Model model) {
		String name = str;
		Book book = bookService.findFName(name);
		
		model.addAttribute("id",book.getBookId());
		model.addAttribute("name",book.getBookName());
		model.addAttribute("publication_year",book.getBookPublicationYear());
		
		return "searchResult";
	}
	
	@PostMapping("/search/db/fromPublicationYear")
	public String postSearchFPublicationYear(@RequestParam("bookPublicationYear")String str,Model model) {
		int PublicationYear = Integer.parseInt(str);
		Book book = bookService.findFPublicationYear(PublicationYear);
		
		model.addAttribute("id",book.getBookId());
		model.addAttribute("name",book.getBookName());
		model.addAttribute("publication_year",book.getBookPublicationYear());
		
		return "searchResult";
		
	}
}
