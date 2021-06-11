package fr.acme.beauregardproject.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table
public class ProductHasOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;
    @NotEmpty
    @Column(nullable = false)
    private float price;
    @NotEmpty
    @Column(nullable = false)
    private int quantity;

    public ProductHasOrder() {
    }

    public ProductHasOrder(Product product, Order order, float price, int quantity) {
        this.product = product;
        this.order = order;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductHasOrder{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + order +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
