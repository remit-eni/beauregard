package fr.acme.beauregardproject.repositories;

import fr.acme.beauregardproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



    @Repository
    public interface LoginRepository extends JpaRepository <User, Long> {

    }
