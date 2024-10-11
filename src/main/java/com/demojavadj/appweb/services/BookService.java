package com.demojavadj.appweb.services;

import com.demojavadj.appweb.models.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookService {
    List<Book> getAllBooks();
    void addBook(Book book);
    Book getBookById(Long id);
    void deleteBook(Long id);
}
