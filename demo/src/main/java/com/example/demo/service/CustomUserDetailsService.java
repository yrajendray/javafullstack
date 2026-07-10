package com.example.demo.service;


import com.example.demo.Entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
	UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        UserBuilder builder = org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail());

        builder.password(user.getPassword());

        builder.roles("USER");

        return builder.build();
    }
}