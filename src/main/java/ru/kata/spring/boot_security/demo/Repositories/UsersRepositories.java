package ru.kata.spring.boot_security.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.Models.User;

import java.util.Optional;

@Repository
public interface UsersRepositories extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);


}
