/*
 * package com.hr.config;
 * 
 * import jakarta.servlet.ServletException; import jakarta.servlet.http.*;
 * import org.springframework.security.core.Authentication; import
 * org.springframework.security.web.authentication.AuthenticationSuccessHandler;
 * 
 * import java.io.IOException;
 * 
 * public class CustomSuccessHandler implements AuthenticationSuccessHandler {
 * 
 * @Override public void onAuthenticationSuccess(HttpServletRequest request,
 * HttpServletResponse response, Authentication authentication) throws
 * IOException {
 * 
 * String role =
 * authentication.getAuthorities().iterator().next().getAuthority();
 * 
 * if (role.equals("ROLE_ADMIN")) {
 * response.sendRedirect("/admin/adminHomePage"); } else if
 * (role.equals("ROLE_HR")) { response.sendRedirect("/hr/homePage"); } else {
 * response.sendRedirect("/employee/empHomePage"); } } }
 */