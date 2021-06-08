package fr.acme.beauregardproject.controllers;

import fr.acme.beauregardproject.entities.Client;
import fr.acme.beauregardproject.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/home")
    public String getHomePage( Model model) {
        List<Client> clients=clientRepository.findTheFirstClient();
        model.addAttribute("clients", clients);
        return "homePage";

    }
}
