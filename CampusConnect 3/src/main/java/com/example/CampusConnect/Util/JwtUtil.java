package com.example.CampusConnect.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import java.util.Date;
import java.security.SecureRandom;
import java.util.Base64;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {


    private String secretKey = "yasemin";

    // Method to generate a token
    public String generateToken(String username,String email) {
        return JWT.create()
                .withSubject(username)
                .withClaim("email", email)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 100)) // 100 hour validity
                .sign(Algorithm.HMAC256(secretKey));
    }

    // Method to validate a token
    public Boolean validateToken(String token, String username) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey))
                    .withSubject(username)
                    .build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception){
            // Token invalid
            return false;
        }
    }

    // Method to extract username from token
    public String extractUsername(String token) {
        DecodedJWT jwt = JWT.decode(token);
        return jwt.getSubject();
    }


}
