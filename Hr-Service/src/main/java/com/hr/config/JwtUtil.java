package com.hr.config;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private static final String SECRET = "0123456789abcdef0123456789abcdef";

	private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

	public String generateToken(String empNetworkId, String role) {
		return Jwts.builder().setSubject(empNetworkId).claim("role", role).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
				.signWith(key).compact();

	}

	private static Claims getClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	public static boolean validateToken(String token) {
		try {
			getClaims(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String extractEmpNetworkIdFromToken(String token) {
		// TODO Auto-generated method stub
		return getClaims(token).getSubject();
	}

	public static String extractRoleFromToken(String token) {
		// TODO Auto-generated method stub
		return (String) getClaims(token).get("role");
	}

}
