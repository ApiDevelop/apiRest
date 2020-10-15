package com.example.apiRest.security;

import com.example.apiRest.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${token.jwt.expiration}")
    private String expiration;

    @Value("${token.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        User logged = (User) authentication.getPrincipal();
        Date today = new Date();
        Date dateExp = new Date(today.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Films API")
                .setSubject(logged.getId().toString())
                .setIssuedAt(today)
                .setExpiration(dateExp)
                .signWith(SignatureAlgorithm.HS256 , secret)
                .compact();
    }
}
