package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.impl.SecurityCustomUserDetailService;

@Configuration
public class SecurityConfig {

    @Autowired
    private SecurityCustomUserDetailService userDetailsService;

    //User create and login using java code with in memory service 
    // @Bean
    // public UserDetailsService userDetailsService(){

    //     UserDetails user1 = User.withDefaultPasswordEncoder().username("admin").password("hash").roles("ADMIN").build();
    //     UserDetails user2 = User.withDefaultPasswordEncoder().username("user").password("user123").roles("USER").build();

    //     var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1, user2);
    //     return inMemoryUserDetailsManager;
    // }

    @Bean
    public AuthenticationProvider authenticatorProvider()
    {
        DaoAuthenticationProvider daoAuthenticatorProvider = new DaoAuthenticationProvider();
        //User Detail service ka object
        daoAuthenticatorProvider.setUserDetailsService(userDetailsService);
        //password Encoder ka object
        daoAuthenticatorProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticatorProvider;
    }

    @Bean
    public SecurityFilterChain securityFileterChain(HttpSecurity httpSecurity) throws Exception{

        //Configuration
        httpSecurity.authorizeHttpRequests(authorize -> {
            // authorize.requestMatchers("/home").permitAll();
            authorize.requestMatchers("/user/**").authenticated();
            authorize.anyRequest().permitAll();
        });

        //form default login
        //agar hume kuch bhi change krna hua to hame yaha ayenge: form login se related
        httpSecurity.formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean 
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
