//package com.codewitharzoo.fullstackbackend.config;
//
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.web.filter.OncePerRequestFilter;
////import javax.servlet.FilterChain;
////import javax.servlet.ServletException;
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
////import java.io.IOException;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//    public JwtAuthenticationFilter(JwtTokenProvider jwtTokenProvider) {
//        this.jwtTokenProvider = jwtTokenProvider;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//            throws ServletException, IOException {
//        try {
//            // Extract the JWT from the Authorization header
//            String jwt = jwtTokenProvider.resolveToken(request);
//
//            if (jwt != null && jwtTokenProvider.validateToken(jwt)) {
//                // If the token is valid, set up the authentication
//                var authentication = new UsernamePasswordAuthenticationToken(null, null, null);
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        } catch (Exception ex) {
//            // Handle exceptions, e.g., token validation failure
//            logger.error("JWT authentication error", ex);
//        }
//
//        // Continue the filter chain
//        filterChain.doFilter(request, response);
//    }
//
//    @Override
//    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
//
//    }
//}
