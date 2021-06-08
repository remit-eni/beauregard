package fr.acme.beauregardproject.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class VAT implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Ce champ ne peut être vide")
    @Column(nullable = false)
    private String name;
    @NotEmpty(message = "Ce champ ne peut être vide")
    @Column(nullable = false)
    private float rate;

    @OneToMany(mappedBy = "vat")
    private List<Product> products;

    public VAT() {

    }

    public VAT(String name, float rate) {
        this.name = name;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "VAT{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}