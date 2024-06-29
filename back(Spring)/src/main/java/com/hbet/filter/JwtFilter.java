package com.hbet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

@WebFilter("/api/*")
public class JwtFilter extends UsernamePasswordAuthenticationFilter implements Filter {
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException {

        String authorizationHeader = req.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            JwtUtil jwtUtil = new JwtUtil();
            try {
                if (jwtUtil.validateToken(token, jwtUtil.extractEmail(token))) {
                    chain.doFilter(req, res);
                } else {
                    ((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT Token");
                }
            } catch (Exception e) {
                ((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT Token");
            }
        } else {
            ((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT Token is missing");
        }
    }
}