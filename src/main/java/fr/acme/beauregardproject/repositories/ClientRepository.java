package fr.acme.beauregardproject.repositories;

import fr.acme.beauregardproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Product, Long> {
}
