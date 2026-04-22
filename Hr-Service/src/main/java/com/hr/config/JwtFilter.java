/*
 * package com.hr.config;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import org.springframework.security.authentication.
 * UsernamePasswordAuthenticationToken; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.context.SecurityContextHolder; import
 * org.springframework.web.filter.OncePerRequestFilter;
 * 
 * import jakarta.servlet.FilterChain; import jakarta.servlet.ServletException;
 * import jakarta.servlet.http.HttpServletRequest; import
 * jakarta.servlet.http.HttpServletResponse;
 * 
 * public class JwtFilter extends OncePerRequestFilter {
 * 
 * @Override protected void doFilterInternal(HttpServletRequest request,
 * HttpServletResponse response, FilterChain filterChain) throws
 * ServletException, IOException {
 * 
 * String header = request.getHeader("Authorization");
 * 
 * System.out.println("this is header" + header);
 * 
 * if (header != null && header.startsWith("Bearer ")) {
 * 
 * String token = header.substring(7);
 * 
 * System.out.println("This is Token" + token); if
 * (JwtUtil.validateToken(token)) {
 * 
 * String empNetworkId = JwtUtil.extractEmpNetworkIdFromToken(token); String
 * role = JwtUtil.extractRoleFromToken(token);
 * 
 * var auth = new UsernamePasswordAuthenticationToken(empNetworkId, null,
 * List.of(new SimpleGrantedAuthority("ROLE_" + role)));
 * 
 * SecurityContextHolder.getContext().setAuthentication(auth); } }
 * 
 * filterChain.doFilter(request, response); }
 * 
 * }
 */