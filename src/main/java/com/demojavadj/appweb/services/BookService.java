package com.demojavadj.appweb.services;

import com.demojavadj.appweb.models.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    void addBook(Book book);
    Book getBookById(Long id);
    void deleteBook(Long id);
    void updateBook(Book book);
}
