package fr.acme.beauregardproject.controllers;

import fr.acme.beauregardproject.entities.Client;
import fr.acme.beauregardproject.entities.User;
import fr.acme.beauregardproject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLoginPage( Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "connexion";
    }

}
