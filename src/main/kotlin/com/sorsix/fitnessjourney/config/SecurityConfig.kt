package com.sorsix.fitnessjourney.config

import org.springframework.context.annotation.Bean

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun SecurityFilterChain(http: HttpSecurity):SecurityFilterChain{
        http.authorizeHttpRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
        return http.build()

    }
}