package fr.acme.beauregardproject.controllers;

import fr.acme.beauregardproject.entities.Order;
import fr.acme.beauregardproject.entities.Product;
import fr.acme.beauregardproject.repositories.ClientRepository;
import fr.acme.beauregardproject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderControllers {

    private static List<Order> orders = new ArrayList<Order>();
    private final ClientRepository clientRepo;
    private final OrderRepository orderRepo;

    @Autowired
    public OrderControllers(ClientRepository clientRepo, OrderRepository orderRepo) {
        this.clientRepo = clientRepo;
        this.orderRepo = orderRepo;
    }

    @GetMapping("/orderPage")
    public String orderPage(Model model) {

        orders = orderRepo.findAll();
        model.addAttribute("orders", orders);

        return "orderPage";
    }

    @GetMapping("/createOrderPage")
    public String showCreateOrder(Order order, Model model) {

        model.addAttribute("clients", clientRepo.findAll());

        return "createOrderPage";
    }

    @PostMapping("/createOrderPage")
    public String createOrder(@Valid Order order, BindingResult result) {
        if (result.hasErrors()) {
            return "createOrderPage";
        }
        orderRepo.save(order);
        return "createOrderPage";
    }

    @PostMapping("/updateOrderPage/{id}")
    public String saveOrder(@PathVariable("id") long id, @Valid Order order,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            order.setId(id);
            return "updateOrderPage";
        }

        orderRepo.save(order);
        return "updateOrderPage";

    }

    @PostMapping("/deleteOrderPage/{id}")
    public String deleteOrder(@PathVariable("id") long id) {

        Order order = orderRepo.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid user ID:" + id));
        orderRepo.delete(order);

        return "redirect:/OrderPage";
    }
}