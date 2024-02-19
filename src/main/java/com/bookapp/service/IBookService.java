package com.bookapp.service;

import com.bookapp.model.Book;

import java.util.List;

public interface IBookService {
    int getCountOfBooks(String author);
    int getBookCount(String author);
    int getCountByAuthor(String author);
    List<Book> getBookListByAuth(String author);
}
