package fr.acme.beauregardproject.controllers;

import fr.acme.beauregardproject.entities.Client;
import fr.acme.beauregardproject.entities.Product;
import fr.acme.beauregardproject.repositories.ClientRepository;
import fr.acme.beauregardproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/clientPage")
    public String getAllClient(@ModelAttribute(value="clientList") ArrayList clientList, Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clientList",  clients);
        model.addAttribute("client",  clientRepository.findById(1L).get());

        return "clientPage";
    }

    @GetMapping("/addClient")
    public String getClientForm( Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "clientForm";
    }

    @PostMapping("/addClient")
    public String addClient(@Valid @ModelAttribute("client") Client client,  BindingResult result, Model model) {
        clientRepository.save(client);

        return "clientForm";
        //return "redirect:/clientPage";
    }

    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        clientRepository.delete(client);
        return "redirect:/clientPage";
    }

    @GetMapping("/editClient/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "updateClientForm";
    }

    @PostMapping("/updateClient/{id}")
    public String updateClient(@Valid @ModelAttribute("client") Client client,@PathVariable long id,
                               BindingResult result, Model model) {
        if (result.hasErrors()) {
            client.setId(id);
            return "updateClientForm";
        }
        clientRepository.save(client);
        return "updateClientForm";
    }
/*
    GetMapping("/searchClient")
    public String searchClient(@Valid ){

    }*/

    @GetMapping("/clientProfile/{id}")
    public String getClientProfile(@PathVariable("id") long id, Model model) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        Date sDate1=client.getBirthdate();
        SimpleDateFormat formater = null;
        formater =new SimpleDateFormat("dd-MM-yyyy");
        formater.format(sDate1);

        //   String strDate = dateFormat.format(client.birthdate);
        model.addAttribute("client", client);
        model.addAttribute("date", sDate1);
        return "clientFiche";
    }



}
