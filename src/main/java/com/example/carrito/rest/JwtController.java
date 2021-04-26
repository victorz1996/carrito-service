package com.example.carrito.rest;

import com.example.carrito.rest.vm.JwtToken;
import com.example.carrito.rest.vm.JwtUser;
import com.example.carrito.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JwtController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/authenticate")
    public JwtToken getToken(@RequestBody JwtUser jwtUser) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(jwtUser.getUsername(), jwtUser.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("Invalid username or password");
        }
        String token = jwtUtil.generateToken(jwtUser.getUsername());
        JwtToken tokenObj = new JwtToken();
        tokenObj.setToken(token);
        return tokenObj;
    }
}
