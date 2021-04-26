package com.example.carrito.service;

import com.example.carrito.entity.Userlogin;
import com.example.carrito.repository.UserloginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserloginRepository userLogInRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userlogin user = userLogInRepository.userByUsername(username);
        return new User(user.getUsername(), user.getPassword(),new ArrayList<>());
    }
}
