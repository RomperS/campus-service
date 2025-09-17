package com.olo.campusservice.infrastructure.config;

import com.olo.campusservice.infrastructure.security.CustomAuthenticationEntryPoint;
import com.olo.campusservice.infrastructure.security.JwtTokenFilter;
import com.olo.internalauthlibrary.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter(JwtService jwtService) {
        return new JwtTokenFilter(jwtService);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtTokenFilter jwtTokenFilter) throws Exception {
        http
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.POST).hasAnyAuthority("SUPER_ADMIN::PRINCIPAL", "ADMIN::SECRETARY")
                        .requestMatchers(HttpMethod.PATCH).hasAnyAuthority("SUPER_ADMIN::PRINCIPAL", "ADMIN::SECRETARY")
                        .requestMatchers(HttpMethod.DELETE).hasAnyAuthority("SUPER_ADMIN::PRINCIPAL", "ADMIN::SECRETARY")
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(exceptions -> exceptions.authenticationEntryPoint(customAuthenticationEntryPoint));

        return http.build();
    }
}