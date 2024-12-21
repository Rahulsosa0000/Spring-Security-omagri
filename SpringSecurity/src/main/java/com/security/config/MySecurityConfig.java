package com.security.config;

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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration    
@EnableWebSecurity  // this tell to spring now you can create own spring security
public class MySecurityConfig {


	@Autowired
	private UserDetailsService userDetailsService;
	
    @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(request->request.anyRequest().authenticated()) // to tell no one can access without authentication
        .formLogin(Customizer.withDefaults())// add form or Customizer is @FunctionalInterface
        .httpBasic(Customizer.withDefaults()) // enable json rest-api
        .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); //create RestApi StateLess(server not save any user info) every time new create id
        
		return http.build();
		
	}
    
//    @Bean
//    public UserDetailsService userDetailsService () {
//    	UserDetails user1= User
//    			.withDefaultPasswordEncoder()
//    			.username("Jigo")
//    			.password("123")
//    			.roles("USER")
//    			.build();
//    	
//    	UserDetails user2= User
//    			.withDefaultPasswordEncoder()
//    			.username("Raju")
//    			.password("123")
//    			.roles("USER")
//    			.build();
//		return new InMemoryUserDetailsManager(user1,user2);
//    	
//    }
    
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//    	
//    	DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
//    	provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//    	provider.setUserDetailsService(userDetailsService);
//    	
//    	return provider;
//    	
//    }
//    
}
  