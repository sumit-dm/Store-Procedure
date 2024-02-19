package com.bookapp;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StoreProcedureApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StoreProcedureApplication.class, args);
	}

	@Autowired
	private IBookService bookService;

	@Override
	public void run(String...args) throws Exception{
		int total = bookService.getCountOfBooks("Robin");
		System.out.println(total);
		total = bookService.getBookCount("Robin");
		System.out.println(total);
		total = bookService.getCountByAuthor("Robin");
		System.out.println(total);

		List<Book> books = bookService.getBookListByAuth("Robin");
		books.forEach(System.out::println);
	}

}
