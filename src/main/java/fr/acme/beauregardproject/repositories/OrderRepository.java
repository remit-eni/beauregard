package fr.acme.beauregardproject.repositories;

import fr.acme.beauregardproject.entities.Order;
import fr.acme.beauregardproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(nativeQuery = true, value="SELECT * FROM `command` ORDER BY creation_date DESC LIMIT 10")
    List<Order> findTheLastOrders();

}
