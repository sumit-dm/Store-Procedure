package com.bookapp.service;

import com.bookapp.model.Book;
import com.bookapp.repository.IBookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public int getCountOfBooks(String author) {
        return bookRepository.get_count_of_books(author);
    }

    @Override
    public int getBookCount(String author) {
        return bookRepository.getBookCount(author);
    }

    @Override
    @Transactional //calling named query from entity class.
    public int getCountByAuthor(String author) {
        return bookRepository.getCountByAuthor(author);
    }

    @Override
    public List<Book> getBookListByAuth(String author) {
        return bookRepository.getBookListByAuth(author);
    }
}
