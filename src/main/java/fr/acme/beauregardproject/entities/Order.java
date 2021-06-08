package fr.acme.beauregardproject.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "command")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;

    @DateTimeFormat(pattern="yyyy-MM-dd hh:mm")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client client;

    @OneToMany(mappedBy = "order")
    List<ProductHasOrder> orderLines;


    public Order() {
    }

    public Order(String reference, LocalDateTime creationDate, Client client) {
        this.reference = reference;
        this.creationDate = creationDate;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", creationDate=" + creationDate +
                ", client=" + client +
                '}';
    }
}