package fr.acme.beauregardproject.controllers;

import fr.acme.beauregardproject.entities.Product;
import fr.acme.beauregardproject.repositories.BrandRepository;
import fr.acme.beauregardproject.repositories.CategoryRepository;
import fr.acme.beauregardproject.repositories.ProductRepository;
import fr.acme.beauregardproject.repositories.VATRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ProductController {

    private static List<Product> products = new ArrayList<Product>();
    private final ProductRepository productRepo;
    private final CategoryRepository catRepo;
    private final VATRepository vatRepo;
    private final BrandRepository brandRepo;

    @Autowired
    public ProductController(ProductRepository productRepo, CategoryRepository catRepo, VATRepository vatRepo, BrandRepository brandRepo) {
        this.productRepo = productRepo;
        this.catRepo = catRepo;
        this.vatRepo = vatRepo;
        this.brandRepo = brandRepo;
    }


    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @GetMapping("/productList")
    public String productList(Model model) {
        products = productRepo.findAll();
        model.addAttribute("products", products);

        return "productList";
    }

    @GetMapping("/addProduct")
    public String showAddProductPage(Product product, Model model) {
        model.addAttribute("categories", catRepo.findAll());
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("vats",vatRepo.findAll());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid Product product, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        productRepo.save(product);
        return "redirect:/productList";
    }

    @GetMapping("/editProduct/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));

        model.addAttribute("product", product);
        model.addAttribute("categories", catRepo.findAll());
        model.addAttribute("brands", brandRepo.findAll());
        model.addAttribute("vats",vatRepo.findAll());
        return "updateProduct";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") long id, @Valid Product product,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            product.setId(id);
            return "updateProduct";
        }

        productRepo.save(product);
        return "redirect:/productList";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") long id, Model model) {
        Product product = productRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user  Id:" + id));
        productRepo.delete(product);
        return "redirect:/productList";
    }


}

