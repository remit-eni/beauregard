package fr.acme.beauregardproject.repositories;

import fr.acme.beauregardproject.entities.ProductHasOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductHasOrderRepository extends JpaRepository<ProductHasOrder, Long> {

        }
