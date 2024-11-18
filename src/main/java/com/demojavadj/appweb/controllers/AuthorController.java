package com.demojavadj.appweb.controllers;


import com.demojavadj.appweb.models.Author;
import com.demojavadj.appweb.services.impl.AuthorServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/listar")
    public String listAllAuthors(Model model) {
        model.addAttribute("title", "Lista de Auttores");
        model.addAttribute("listaAuthor", authorService.getAllAuthors());
        return "pages/list-author";
    }

    @GetMapping("/nuevo")
    public  String addAuthor(Model model){
        Author author = new Author();
        model.addAttribute("title", "Agregar Autor");
        model.addAttribute("author", author);
        return "pages/form-author";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("author") Author author){
        authorService.addAuthor(author);
        return "redirect:/author/listar";
    }

    @GetMapping("/showUpdateAuthor/{id}")
    public String updateCustomer(@PathVariable(value="id") Long id,Model model){
        Author author = authorService.getAuthorById(id);
        model.addAttribute("author", author);
        return "pages/form-authorActualizar";
    }
    @PostMapping("/update")
    public String updateAuthor(@ModelAttribute("author") Author author) {
        authorService.updateAuthor(author);
        return "redirect:/author/listar";
    }


    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable(value="id") Long id){
        authorService.deleteAuthor(id);
        return "redirect:/author/listar";

    }
}
