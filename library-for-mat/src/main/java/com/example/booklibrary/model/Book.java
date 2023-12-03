package com.example.booklibrary.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    private Integer idbook;
    private String bookName;
    private Integer bookCount;


    public Book() {
    }

    public Book(Integer idbook, String bookName, Integer bookCount) {
        this.idbook = idbook;
        this.bookName = bookName;
        this.bookCount = bookCount;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdbook() {
        return idbook;
    }

    public void setIdbook(Integer idbook) {
        this.idbook = idbook;
    }

    @Column
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Column
    public Integer getBookCount() {
        return bookCount;
    }

    public void setBookCount(Integer bookCount) {
        this.bookCount = bookCount;
    }

}
