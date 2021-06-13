package fr.acme.beauregardproject.controllers;

import fr.acme.beauregardproject.entities.Client;
import fr.acme.beauregardproject.entities.Order;
import fr.acme.beauregardproject.entities.Product;
import fr.acme.beauregardproject.repositories.ClientRepository;
import fr.acme.beauregardproject.repositories.OrderRepository;
import fr.acme.beauregardproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/")
    public String getHomePage( Model model) {
        List<Product> products=productRepository.findTheMostSoldProducts();
        List<Order> orders= orderRepository.findTheLastOrders();
        model.addAttribute("products", products);
        model.addAttribute("orders", orders);
        return "homePage";

    }
}
