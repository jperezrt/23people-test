package com.twentythreepeople.ms.app.test.controllers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class JWTController {

    @GetMapping("token")
    public ResponseEntity<?> generateToken(Pageable pageable) {
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

    ResponseEntity<?> validate(BindingResult bindingResult){
        Map<String, Object> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach( err -> {
            errors.put("message", "Field " + err.getField() + ", " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
