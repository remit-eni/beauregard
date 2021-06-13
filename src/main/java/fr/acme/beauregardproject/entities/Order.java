package fr.acme.beauregardproject.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "command")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Le champ référence ne peut être vide")
    @Column(nullable = false)
    private String reference;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date creationDate;

    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client client;

    @OneToMany(mappedBy = "order")
    List<ProductHasOrder> orderLines= new ArrayList<>();

    public Order() {
    }

    public Order(String reference, Date creationDate, Client client) {
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
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
                //", client=" + client +
                '}';
    }
}