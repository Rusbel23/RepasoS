package com.demojavadj.appweb.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code_book")
    private String code_Book;
    @NotEmpty(message = "El nombre es obligatorio")
    private String name;
    @NotEmpty(message = "El titulo es obligatorio")
    private String title;
    @NotEmpty(message = "El publicación es obligatorio")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publisher;
    private char sbn;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;

    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    public Book() {
    }

    public Book(Long id, String code_Book, String name, String title, Date publisher, char sbn, Date createAt, Date updateAt, Author author) {
        this.id = id;
        this.code_Book = code_Book;
        this.name = name;
        this.title = title;
        this.publisher = publisher;
        this.sbn = sbn;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode_Book() {
        return code_Book;
    }

    public void setCode_Book(String code_Book) {
        this.code_Book = code_Book;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublisher() {
        return publisher;
    }

    public void setPublisher(Date publisher) {
        this.publisher = publisher;
    }

    public char getSbn() {
        return sbn;
    }

    public void setSbn(char sbn) {
        this.sbn = sbn;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
