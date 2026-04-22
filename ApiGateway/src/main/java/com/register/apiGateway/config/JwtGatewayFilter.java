package com.register.apiGateway.config;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtGatewayFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();
        
        System.out.println("Path from Api " + path);

        // 🔓 Allow login API without token
        if (path.contains("/hr/login") || path.contains("/hr/createUser")) {
            return chain.filter(exchange);
        }

        // 🔐 Get header
        String header = exchange.getRequest().getHeaders().getFirst("Authorization");
        System.out.println("HEADER from GATEWAY: " + header);
        
        if (header == null || !header.startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = header.substring(7);

        try {
            var claims = JwtUtil.validateToken(token);

            String role = claims.get("role", String.class);
            System.out.println("Role fro Gateway " +role);

            // 🔥 ROLE CHECK
            if (!isAuthorized(path, role)) {
                exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }

        } catch (Exception e) {
            exchange.getResponse().setStatusCode(org.springframework.http.HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    // 🔥 RBAC Logic
    private boolean isAuthorized(String path, String role) {

        if (path.startsWith("/admin") && !role.equals("ADMIN")) {
            return false;
        }

        if (path.startsWith("/hr") && !(role.equals("HR") || role.equals("ADMIN"))) {
            return false;
        }

        if (path.startsWith("/employee") &&
                !(role.equals("EMPLOYEE") || role.equals("HR") || role.equals("ADMIN"))) {
            return false;
        }

        return true;
    }

	
}