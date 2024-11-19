package com.oauth2admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public JwtDecoder jwtDecoder() {

    return JwtDecoders.fromIssuerLocation("http://localhost:9000");
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.oauth2ResourceServer(resource -> resource.jwt(Customizer.withDefaults()));
    http.authorizeHttpRequests(auth -> auth
        .requestMatchers("/me").hasAuthority("SCOPE_profile")
        .anyRequest().authenticated()
    );
    http.sessionManagement(session -> session
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    );

    return http.build();
  }
}
