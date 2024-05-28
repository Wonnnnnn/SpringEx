package org.example.ditest.config;

import lombok.RequiredArgsConstructor;
import org.example.ditest.controller.LoginSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class SpringConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(
                        new AntPathRequestMatcher("/"),
                        new AntPathRequestMatcher("/favicon.ico"),
                        new AntPathRequestMatcher("/login"),
                        new AntPathRequestMatcher("/users/new"),
                        new AntPathRequestMatcher("/index.html")).permitAll()
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
