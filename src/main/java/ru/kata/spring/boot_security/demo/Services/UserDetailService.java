package ru.kata.spring.boot_security.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.Models.User;
import ru.kata.spring.boot_security.demo.Repositories.UsersRepositories;
import ru.kata.spring.boot_security.demo.Security.UserDetails;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    private final UsersRepositories usersRepositories;
@Autowired
    public UserDetailService(UsersRepositories usersRepositories) {
        this.usersRepositories = usersRepositories;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = usersRepositories.findByUsername(username);
        if (user.isEmpty()){
            throw new UsernameNotFoundException("User not found!");
        }
        return new UserDetails(user.get());
    }
}
