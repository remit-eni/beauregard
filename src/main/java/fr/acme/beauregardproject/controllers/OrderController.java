package fr.acme.beauregardproject.controllers;

import fr.acme.beauregardproject.entities.Order;
import fr.acme.beauregardproject.entities.Product;
import fr.acme.beauregardproject.entities.ProductHasOrder;
import fr.acme.beauregardproject.repositories.ClientRepository;
import fr.acme.beauregardproject.repositories.OrderRepository;
import fr.acme.beauregardproject.repositories.ProductHasOrderRepository;
import fr.acme.beauregardproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    private static List<Order> orders = new ArrayList<Order>();
    private final ClientRepository clientRepo;
    private final OrderRepository orderRepo;
    private final ProductHasOrderRepository productHasOrderRepo;

    @Autowired
    public OrderController(ClientRepository clientRepo, OrderRepository orderRepo, ProductHasOrderRepository productHasOrderRepo) {
        this.clientRepo = clientRepo;
        this.orderRepo = orderRepo;
        this.productHasOrderRepo = productHasOrderRepo;
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
        model.addAttribute("product", productHasOrderRepo.findAll());

        return "createOrderPage";
    }

    @PostMapping("/createOrderPage")
    public String createOrder(@Valid Order order, BindingResult result) {
        Date dateDujour = new Date();
        if (result.hasErrors()) {
            return "createOrderPage";
        }
        order.setCreationDate(dateDujour);
        orderRepo.save(order);
        return "redirect:/orderPage";
    }

    @GetMapping("/editOrderPage/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));

        model.addAttribute("order", order);
        model.addAttribute("clients", clientRepo.findAll());
        // model.addAttribute("product", productHasOrderRepo.findAll());
        return "updateOrderPage";
    }


    @PostMapping("/updateOrderPage/{id}")
    public String updateOrderPage(@PathVariable("id") long id, @Valid Order order,
                            BindingResult result, Model model) {
        if (result.hasErrors()) {
            order.setId(id);
            return "updateOrderPage";
        }

        orderRepo.save(order);
        return "redirect:/orderPage";

    }

    @GetMapping("/deleteOrderPage/{id}")
    public String deleteOrder(@PathVariable("id") long id) {

        Order order = orderRepo.findById(id).orElseThrow(() ->new IllegalArgumentException("Invalid user ID:" + id));
        orderRepo.delete(order);

        return "redirect:/orderPage";
    }

    @GetMapping("/orderCard/{id}")
    public String getOrderCard(@PathVariable("id") long id, Model model) {

        Order order = orderRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
        model.addAttribute("products",productHasOrderRepo.findProducts());
        model.addAttribute("order", order);
        return "orderCard";
    }
}