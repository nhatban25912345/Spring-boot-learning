//package org.example.springbootlearning.filter;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import java.security.Key;
//import java.util.Date;
//import java.util.function.Function;
//
//@Component
//public class JwtUtil {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private int expiration;
//
//    public String generateToken(String subject) {
//        return Jwts.builder()
//                .setSubject(subject)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L))
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    public boolean validateToken(String token, String subject) {
//        final String tokenSubject = extractSubject(token);
//        return (tokenSubject.equals(subject) && !isTokenExpired(token));
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    public String extractSubject(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public Date extractExpirationDate(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractExpirationDate(token).before(new Date());
//    }
//
//}
