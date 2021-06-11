package fr.acme.beauregardproject.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Le champ numberStreet ne peut être vide")
    @Column(nullable = false)
    @Size(min = 1, max = 5)
    private String numberStreet;

    @NotEmpty(message = "Le champ street ne peut être vide")
    @Column(nullable = false)
    @Size(min = 3, max = 150)
    private String street;

    @NotEmpty(message = "Le champ city ne peut être vide")
    @Column(nullable = false)
    @Size(min = 3, max = 15)
    private String city;

    @NotEmpty(message = "Le champ zip ne peut être vide")
    @Column(nullable = false)
    @Size(min = 1, max = 5)
    private String zip;


    @OneToMany(mappedBy = "address")
    private List<Client> clients = new ArrayList<>();

    public Address() {
    }

    public Address(String numberStreet, String street, String city, String zip) {
        this.numberStreet = numberStreet;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(String numberStreet) {
        this.numberStreet = numberStreet;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", numberStreet='" + numberStreet + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
            ", clients=" + clients +
                '}';
    }
}