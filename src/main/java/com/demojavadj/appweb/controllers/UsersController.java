package com.demojavadj.appweb.controllers;

import com.demojavadj.appweb.models.Users;
import com.demojavadj.appweb.services.impl.UsersServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UsersServiceImpl usersService;

    public UsersController(UsersServiceImpl usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/listar")
    public String listAllUsers(Model model) {
        model.addAttribute("title", "Lista de Usuarios");
        model.addAttribute("listaUsers", usersService.getAllUsers());
        return "pages/list-users";
    }

    @GetMapping("/nuevo")
    public String addUser(Model model) {
        Users user = new Users();
        model.addAttribute("title", "Agregar Usuario");
        model.addAttribute("user", user);
        return "pages/form-users";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") Users user, @RequestParam("role") String role) {
        usersService.addUser(user, role);
        return "redirect:/users/listar";
    }

    @GetMapping("/showUpdateUser/{id}")
    public String updateUser(@PathVariable(value = "id") Long id, Model model) {
        Users user = usersService.getUserById(id);
        model.addAttribute("user", user);
        return "pages/form-usersActualizar";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") Users user) {
        usersService.updateUser(user);
        return "redirect:/users/listar";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        usersService.deleteUser(id);
        return "redirect:/users/listar";
    }
}
