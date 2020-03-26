package com.twentythreepeople.ms.app.test.controllers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/token")
public class JWTController {

    @GetMapping("")
    public ResponseEntity<?> generateToken() {
        return ResponseEntity.ok().body(this.getJWTToken());
    }

    private String getJWTToken() {
        String secretKey = "mySecretKey";
        Claims claims = Jwts.claims().setSubject("test");
        claims.put("userId", 1 + "");
        claims.put("role", "TESTER");
        String token = Jwts
                .builder()
                .setSubject("test")
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();
        return token;
    }
}
