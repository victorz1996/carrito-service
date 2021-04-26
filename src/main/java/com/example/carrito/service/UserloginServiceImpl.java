package com.example.carrito.service;

import com.example.carrito.entity.Userlogin;
import com.example.carrito.repository.UserloginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserloginServiceImpl implements UserloginService{

    private final UserloginRepository userloginRepository;

    @Override
    public List<Userlogin> listAllUsers() {
        return userloginRepository.findAll();
    }

    @Override
    public Userlogin getUser(Long id) {
        return userloginRepository.findById(id).orElse(null);
    }

    @Override
    public Userlogin createUser(Userlogin userlogin) {
        Userlogin userlogin1 = userloginRepository.getUser(userlogin.getId());
        if( userlogin1 != null ){
            return userlogin1;
        }
        return userloginRepository.save(userlogin);
    }

    @Override
    public Userlogin updateUser(Userlogin userlogin) {
        Userlogin userlogin1 = getUser(userlogin.getId());
        if(userlogin1 == null){
            return null;
        }
        if(userlogin.getUsername() != null){
            userlogin1.setUsername(userlogin.getUsername());
        }
        if(userlogin.getPassword() != null){
            userlogin1.setPassword(userlogin.getPassword());
        }
        return userloginRepository.save(userlogin1);
    }

    @Override
    public void deleteUser(Long id) {
        userloginRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userloginRepository.deleteAllInBatch();
    }
}
