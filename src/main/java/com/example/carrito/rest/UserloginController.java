package com.example.carrito.rest;

import com.example.carrito.entity.Userlogin;
import com.example.carrito.service.UserloginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserloginController {

    private final UserloginService userloginService;

    @GetMapping
    public ResponseEntity<List<Userlogin>> getAllUsers() {
        return ResponseEntity.ok().body(userloginService.listAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Userlogin> getUser(@PathVariable("id") Long id){
        Userlogin userlogin = userloginService.getUser(id);
        if(userlogin == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userlogin);
    }

    @PostMapping
    public ResponseEntity<Userlogin> createUser(@RequestBody Userlogin userlogin){
        return ResponseEntity.status(HttpStatus.CREATED).body(userloginService.createUser(userlogin));
    }
}
