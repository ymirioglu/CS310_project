package com.example._0.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/addUser").permitAll() // Allow access to /addUser without authentication
                        .anyRequest().authenticated() // Require authentication for all other requests
                )
                .csrf(csrf -> csrf.disable()) // Disables CSRF protection
                .httpBasic(withDefaults()); // Enables basic HTTP authentication with the updated syntax

        return http.build();
    }
}
