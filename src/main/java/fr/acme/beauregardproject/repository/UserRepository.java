package fr.acme.beauregardproject.repository;


import fr.acme.beauregardproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(" select u from User u  where u.firstname = ?1")
    Optional<User> findUserWithName(String firstname);

}
