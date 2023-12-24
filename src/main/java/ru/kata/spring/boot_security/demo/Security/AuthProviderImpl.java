package ru.kata.spring.boot_security.demo.Security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.Services.UserDetailService;

import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final UserDetailService userDetailService;

    public AuthProviderImpl(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        String password = authentication.getCredentials().toString();
        if (!password.equals(userDetails.getPassword())){
            throw new BadCredentialsException("Incorrect password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
