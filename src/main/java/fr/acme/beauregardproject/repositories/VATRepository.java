package fr.acme.beauregardproject.repositories;

import fr.acme.beauregardproject.entities.VAT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VATRepository extends JpaRepository<VAT, Long> {
}
