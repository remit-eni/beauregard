package fr.acme.beauregardproject.repositories;

import fr.acme.beauregardproject.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(nativeQuery = true, value="SELECT * FROM Client LIMIT 10 ")
    List<Client> findTheFirstClient();

    /* Produts les plus vendus
    SELECT Product.label, sum(Product_has_order.quantity) AS quantite
    FROM Product_has_order, Product
    WHERE Product_has_order.product_id = product.id
    ORDER BY quantite ASC
    LIMIT 10 */
}