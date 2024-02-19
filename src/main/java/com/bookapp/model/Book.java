package com.bookapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "getBookCountByAuthor",
        procedureName = "get_count_of_books",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "auth",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT,name = "total",type= Integer.class)
        })
public class Book {
    private String title;
    private String author;
    @Id
    private Integer bookId;
    @Column(name = "cost")
    private double price;
    private String category;


}
