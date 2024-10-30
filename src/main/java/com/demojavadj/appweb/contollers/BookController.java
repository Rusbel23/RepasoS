package com.demojavadj.appweb.contollers;

import com.demojavadj.appweb.models.Book;
import com.demojavadj.appweb.services.impl.BookServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/listar")
    public String listAllBooks(Model model) {
        model.addAttribute("title", "Lista de Libros");
        model.addAttribute("listaBook", bookService.getAllBooks());
        return "pages/list-book";
    }

    @GetMapping("/nuevo")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("title", "Agregar Libro");
        model.addAttribute("book", book);
        return "pages/form-book";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/book/listar";
    }

    @GetMapping("/showUpdateBook/{id}")
    public String updateBook(@PathVariable(value = "id") Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "pages/form-bookActualizar";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book) {
        bookService.updateBook(book);
        return "redirect:/book/listar";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/book/listar";
    }
}
