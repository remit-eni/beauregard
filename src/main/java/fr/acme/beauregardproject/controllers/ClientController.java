package fr.acme.beauregardproject.controllers;

import fr.acme.beauregardproject.entities.Address;
import fr.acme.beauregardproject.entities.Client;
import fr.acme.beauregardproject.entities.Company;
import fr.acme.beauregardproject.repositories.AddressRepository;
import fr.acme.beauregardproject.repositories.ClientRepository;
import fr.acme.beauregardproject.repositories.CompanyRepository;
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
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    private AddressRepository addressRepository;
    private CompanyRepository companyRepository;

    @GetMapping("/clientPage")
    public String getAllClient(@ModelAttribute(value="clientList") ArrayList clientList, Model model) {
        List<Client> clients = clientRepository.findAll();
        model.addAttribute("clientList",  clients);
        model.addAttribute("client",  clientRepository.getOne(1L));

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
}