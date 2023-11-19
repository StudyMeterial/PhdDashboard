//package com.codewitharzoo.fullstackbackend.config;
////package com.codewitharzoo.fullstackbackend.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        // Define users and their roles
//        var user = User.withUsername("user").password("{noop}password").roles("USER").build();
//        var admin = User.withUsername("admin").password("{noop}password").roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
//
//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter() {
//        return new JwtAuthenticationFilter(null);
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers("/api/secured").hasRole("ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .and()
//                .httpBasic();
//    }
//}
