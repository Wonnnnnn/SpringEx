package org.example.spring_jpa.config;

import org.example.spring_jpa.controller.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .requestMatchers("/login", "/swagger-ui/**", "/users/new").permitAll()
        .anyRequest().authenticated();
    http.formLogin(login -> login.loginPage("/login")
                .usernameParameter("userId")
                .passwordParameter("password")
                .successHandler(new LoginSuccessHandler())
            //.defaultSuccessUrl("/posts")
        )
        .exceptionHandling(exception -> exception.accessDeniedPage("/access-denied"));

    return http.build();
  }

}
