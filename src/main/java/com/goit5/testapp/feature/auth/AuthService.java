package com.goit5.testapp.feature.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AuthService {
    public boolean hasAuthority(String name) {
        Collection<GrantedAuthority> authorities = getUser().getAuthorities();

        System.out.println("User: " + name);
        System.out.println(authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        return authorities.stream().map(GrantedAuthority::getAuthority).anyMatch(it -> it.equals(name));
    }

    public String getUsername() {
        return getUser().getUsername();
    }

    private User getUser() {
        return (User) getAuthentication().getPrincipal();
    }

    private Authentication getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();

        Authentication authentication = context.getAuthentication();

        System.out.println("authentication.getClass() = " + authentication.getClass());

        return authentication;
    }
}
