package com.register.apiGateway.config;

import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JwtUtil {
	private static final String SECRET = "0123456789abcdef0123456789abcdef";

	private static final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
	
	

	public static Claims validateToken(String token) {

		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}
}