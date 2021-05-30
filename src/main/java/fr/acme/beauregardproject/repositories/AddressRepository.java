package fr.acme.beauregardproject.repositories;

import fr.acme.beauregardproject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Client, Long> {

}