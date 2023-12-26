package ru.kata.spring.boot_security.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.Models.User;
import ru.kata.spring.boot_security.demo.Repositories.UsersRepositories;
@Service
public class RegistrationService {
    private final UsersRepositories usersRepositories;

    @Autowired
    public RegistrationService(UsersRepositories usersRepositories) {
        this.usersRepositories = usersRepositories;
    }
    @Transactional
    public void register(User user){
        usersRepositories.save(user);
    }
}
