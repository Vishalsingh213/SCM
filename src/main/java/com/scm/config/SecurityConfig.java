package com.scm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    //User create and login using java code with in memory service 
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user1 = User.withDefaultPasswordEncoder().username("admin").password("hash").roles("ADMIN").build();
        UserDetails user2 = User.withDefaultPasswordEncoder().username("user").password("user123").roles("USER").build();

        var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1, user2);
        return inMemoryUserDetailsManager;
    }
}
