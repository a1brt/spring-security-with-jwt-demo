package com.example.demo.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {
    private final static List<UserDetails> USERS = Arrays.asList(
            new User(
                    "a@gmail.com",
                    new BCryptPasswordEncoder().encode("password1"),
                    List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User(
                    "b@gmail.com",
                    new BCryptPasswordEncoder().encode("password2"),
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );


    public UserDetails findUserByEmail(String email){
        return USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(()-> new UsernameNotFoundException("User doesn't exist"));
    }
}
