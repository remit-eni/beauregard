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
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Ce champ ne peut être vide")
    @Column(nullable = false)
    private String label;

    @OneToMany(mappedBy = "brand")
    private List<Product> products= new ArrayList<>();

    public Brand() {
    }

    public Brand(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}