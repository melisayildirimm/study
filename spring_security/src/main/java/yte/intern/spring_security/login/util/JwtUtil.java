package yte.intern.spring_security.login.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUtil {

    public static String generateToken(Authentication user,String key){
        return Jwts.builder()
                .setSubject(user.getName())
                .claim("authorities", getAuthorities(user))
                .setExpiration(getExpirationDate())
                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
                .compact();

    }

    private static Date getExpirationDate() {
        Instant expirationTime = LocalDate.now()
                .plusDays(7)
                .atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant();
        return Date.from(expirationTime);

    }

    private static List<String> getAuthorities(Authentication user) {
        return user.getAuthorities()
                .stream()
                .map(authority -> authority.getAuthority())
                .collect(Collectors.toList());
    }

    public static String extractUsername(String jwtToken, String secretKey) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes()))
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();

        return claims.getSubject();

    }
}
