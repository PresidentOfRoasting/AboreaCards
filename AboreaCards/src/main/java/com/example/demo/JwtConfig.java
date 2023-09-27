package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

//@Configuration
public class JwtConfig {

    /*@Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    @Bean
    public Key key() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public long getExpiration() {
        return expiration;
    }*/
}
