package com.bookapp.repository;

import com.bookapp.model.Book;
import jakarta.persistence.NamedStoredProcedureQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Serializable> {

    //1. use procedure name as the method name
    @Procedure
    int get_count_of_books(String author);

    //2.Using @Procedure with different method name,Use attributes to pass procedureName.Can use Value inplace of procedureName
    @Procedure(procedureName = "get_count_of_books")
    int getBookCount(String author);

    //3.Using @NamedStoredProcedureQuery() annotation.Linked to NamedStoredProcedure in Entity
    @Procedure(name = "getBookCountByAuthor")
    int getCountByAuthor(@Param("auth") String author);

    //4.Using @Query annotaion. only work for stored procedure that take input and no output.
    @Query(value = "call get_books_by_author(:author)",nativeQuery = true)
    List<Book> getBookListByAuth(@Param("author") String author);

}
