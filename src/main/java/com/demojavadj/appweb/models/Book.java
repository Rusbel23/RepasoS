package com.demojavadj.appweb.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "code_book")
    private String code_Book;
    private String name;
    private String title;
    private Date plubisher;
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

    public Book(Long id, String code_Book, String name, String title, Date plubisher, char sbn, Date createAt, Date updateAt) {
        this.id = id;
        this.code_Book = code_Book;
        this.name = name;
        this.title = title;
        this.plubisher = plubisher;
        this.sbn = sbn;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeBook() {
        return code_Book;
    }

    public void setCodeBook(String codeBook) {
        this.code_Book = codeBook;
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

    public Date getPlubisher() {
        return plubisher;
    }

    public void setPlubisher(Date plubisher) {
        this.plubisher = plubisher;
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
}
