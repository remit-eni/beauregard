package fr.acme.beauregardproject.service;

import fr.acme.beauregardproject.entities.User;
import fr.acme.beauregardproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j

public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String firstname) throws UsernameNotFoundException {

        Objects.requireNonNull(firstname);
        User user = userRepository.findUserWithName(firstname)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return user;
    }

}
