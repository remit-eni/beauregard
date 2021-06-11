package fr.acme.beauregardproject.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Ce champ ne peut être vide")
    @Column(nullable = false)
    private String label;
    @NotEmpty(message = "Ce champ ne peut être vide")
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products= new ArrayList<>();

    public Category() {

    }

    public Category(String label, String description) {

        this.label = label;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}