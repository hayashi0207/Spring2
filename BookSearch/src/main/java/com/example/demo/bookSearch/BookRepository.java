package com.example.demo.bookSearch;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Map<String, Object> findFId(int id){
		String sql = "SELECT"
				+ " book_id,"
				+ " book_name,"
				+ " book_publication_year"
				+ " FROM book"
				+ " WHERE book_id=?";
		
		Map<String,Object> book = jdbcTemplate.queryForMap(sql,id);
		return book;
	}
	public Map<String,Object> findFName(String name){
		String sql = "SELECT"
				+ " book_id,"
				+ " book_name,"
				+ " book_publication_year,"
				+ " FROM"
				+ " book"
				+ " WHERE"
				+ " book_name=?";
		
		Map<String,Object> book = jdbcTemplate.queryForMap(sql,name);
		return book;
	}
	public Map<String,Object> findFPublicationYear (int publicationYear){
		String sql = "SELECT"
				+ " book_id,"
				+ " book_name,"
				+ " book_publication_year"
				+ " FROM"
				+ " book"
				+ " WHERE"
				+ " book_publication_year=?";
		
		Map<String,Object> book = jdbcTemplate.queryForMap(sql,publicationYear);
		return book;
	}
}
