package fr.acme.beauregardproject.repositories;

import fr.acme.beauregardproject.entities.Client;
import fr.acme.beauregardproject.entities.ProductHasOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductHasOrderRepository extends JpaRepository<ProductHasOrder, Long> {
        @Query(nativeQuery = true, value="SELECT * FROM `product_has_order` JOIN `product` WHERE product.id= product_has_order.product_id")
        List<ProductHasOrder> findProducts();
}
