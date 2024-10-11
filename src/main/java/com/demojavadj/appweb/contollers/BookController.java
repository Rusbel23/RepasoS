package com.demojavadj.appweb.contollers;

import com.demojavadj.appweb.models.Author;
import com.demojavadj.appweb.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/listar")
    public String listr(Model model){
        model.addAttribute("book");
        model.addAttribute("book", "Esto es el libro");
        return "pages/list-book";
    }
    @GetMapping("/nuevo")
    public  String addAuthor(Model model){
        Book book = new Book();
        model.addAttribute("title", "Agregar Autor");
        model.addAttribute("book", book);
        return "pages/form-book";
    }

    @GetMapping("/atributo")
    public String atributos(Model model){
        Integer numero1 = 12;
        Integer numero2 = 13;
        Integer cifra = 12345;
        Date fecha = new Date();
        List<String> paises = new ArrayList<String>();
        paises.add("Peru");
        paises.add("Madrid");
        paises.add("Malta");
        paises.add("Rome");

        model.addAttribute("numero1", numero1);
        model.addAttribute("numero2", numero2);
        model.addAttribute("cifra", cifra);
        model.addAttribute("fecha", fecha);
        model.addAttribute("paises", paises);
        return "template/atributos";
    }
}
