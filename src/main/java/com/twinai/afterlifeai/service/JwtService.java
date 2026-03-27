package com.twinai.afterlifeai.service;

import com.twinai.afterlifeai.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET = "my-super-secret-key-my-super-secret-key"; // must be long
    private static final long EXPIRATION = 1000 * 60 * 60; // 1 hour

    // 🔹 Generate signing key
    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // 🔹 Generate Token
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 🔹 Extract Email
    public String extractEmail(String token) {
        return extractClaims(token).getSubject();
    }

    // 🔹 Extract Claims
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 🔹 Validate Token
    public boolean isValid(String token, User user) {
        String email = extractEmail(token);
        return email.equals(user.getEmail()) && !isExpired(token);
    }

    // 🔹 Check Expiration
    private boolean isExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }
}