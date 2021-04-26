package com.example.carrito.repository;

import com.example.carrito.entity.Userlogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserloginRepository extends JpaRepository<Userlogin, Long> {
    @Query("select u from Userlogin u where u.username = :username")
    public Userlogin userByUsername(String username);

    @Query("select u from Userlogin u where u.id = :id")
    public Userlogin getUser(Long id);
}
