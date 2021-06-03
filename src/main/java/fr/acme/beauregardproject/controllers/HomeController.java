package fr.acme.beauregardproject.controllers;

import fr.acme.beauregardproject.entities.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping ("/")
    public String index(Model model){
        model.addAttribute("order",new Order());
    return "homePage";

    }
}
