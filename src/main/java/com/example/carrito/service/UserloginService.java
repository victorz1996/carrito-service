package com.example.carrito.service;


import com.example.carrito.entity.Userlogin;

import java.util.List;

public interface UserloginService {
    public List<Userlogin> listAllUsers();
    public Userlogin getUser(Long id);
    public Userlogin createUser(Userlogin userlogin);
    public Userlogin updateUser(Userlogin userlogin);
    public void deleteUser(Long id);
    public void deleteAllUsers();
}
