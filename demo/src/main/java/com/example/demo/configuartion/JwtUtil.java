package com.example.demo.configuartion;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Secret key (minimum 32 characters)
    private static final String SECRET =
            "mySecretKeyForJwtAuthentication123456789";

    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    // Token Validity = 24 Hours
    private static final long EXPIRATION = 1000 * 60 * 60 * 24;

    // Generate JWT Token
    public String generateToken(String username) {

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract Username
    public String extractUsername(String token) {

        return getClaims(token).getSubject();
    }

    // Validate Token
    public boolean validateToken(String token, String username) {

        return username.equals(extractUsername(token))
                && !isTokenExpired(token);
    }

    // Check Expiration
    private boolean isTokenExpired(String token) {

        return getClaims(token)
                .getExpiration()
                .before(new Date());
    }

    // Get Claims
    private Claims getClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}