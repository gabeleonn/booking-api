package com.example.booking.configuration.Security;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

    @Value("${security.jwt.expireTime}")
    private String expireTime;

    @Value("${security.jwt.secret}")
    private String secretKey;


    public Claims getClaims(String token) {
        return Jwts
                    .parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();   
    }
    
    public boolean validateToken(String token) {

        try {
            Claims claims = getClaims(token);
            Date dateExpiration = claims.getExpiration();
            LocalDateTime date = dateExpiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(date);

        } catch (Exception e) {
            return false;
        }
        
    }

    public String getEmployeeEmail(String token) throws ExpiredJwtException {
        return (String) getClaims(token).getSubject();
    }

    public String generateToken(UserDetails employee) {
        long expString = Long.valueOf(expireTime);
        LocalDateTime dateExpiration = LocalDateTime.now().plusMinutes(expString);
        Instant instant = dateExpiration.atZone(ZoneId.systemDefault()).toInstant();
        Date jwtDate = Date.from(instant);
        return Jwts.builder()
                    .setSubject(employee.getUsername())
                    .setExpiration(jwtDate)
                    .signWith(SignatureAlgorithm.HS512, secretKey)
                    .compact();

    }
    
}
