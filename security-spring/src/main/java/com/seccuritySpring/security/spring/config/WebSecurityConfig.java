package com.seccuritySpring.security.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();

        provider.setUserDetailsPasswordService(userDetailsService);
        provider.serPasswordEncoder(NoOpPasswordEncoder.getInstance());


        return provider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        httpSecurity
                .csrf(customize->customize.disable())
                .authorizeHttpRequests(auth->
                        auth.requestMatchers("/library/**").permitAll())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .sessionManagement(
                        session->
                                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user= User
//                .withDefaultPasswordEncoder()
//                .username("ravi")
//                .password("Ravi@123")
//                .build();
//        UserDetails admin= User
//                .withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin@123")
//                .build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }
}
