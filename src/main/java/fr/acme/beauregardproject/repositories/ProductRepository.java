package fr.acme.beauregardproject.repositories;

import fr.acme.beauregardproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(nativeQuery = true, value="SELECT product.*, sum(product_has_order.quantity) AS quantite\n" +
            "   FROM product_has_order, product\n" +
            "    WHERE product_has_order.product_id = product.id\n" +
            "    ORDER BY quantite ASC\n" +
            "    LIMIT 10 ")
    List<Product> findTheMostSoldProducts();

    /* Produts les plus vendus
     */
}
