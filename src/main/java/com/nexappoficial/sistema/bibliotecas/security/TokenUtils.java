package com.nexappoficial.sistema.bibliotecas.security;

import com.nexappoficial.sistema.bibliotecas.entities.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.swing.*;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private static final String ACCESS_TOKEN_SECRET = "MIIEowIBAAKCAQEAsK12vjGRLvSsqdIAFCitRMf6M4PzQii/PhrrIo6hcvWj8rM2";
    private static final Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    // Token enviado al cliente
    public static String createToken(String username, String email, String password) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("username", username);
        extra.put("email", email);
        extra.put("password", password);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    /* PasswordUsernameAuthenticationToken Es Algo Válido Para Que Spring Security
       Reconozca Un Usuario Con Autorizacion */
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }
    }
}
