package fr.acme.beauregard_project.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String street;
    private String city;
    private String zip;

    @OneToMany(mappedBy = "client")
    private Set<Client> clients;

    {
        clients = new HashSet<Client>();
    }

    public Address() {
    }

    public Address(String number, String street, String city, String zip) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", clients=" + clients +
                '}';
    }
}
