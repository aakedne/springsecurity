package com.example.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //set up protected method
    protected void configure(HttpSecurity http) throws Exception{ //if anything happens wewoud through exception
        http.authorizeRequests()  // authorizes when login (authentication)
                .antMatchers("/", "/home").permitAll() //this is for authorize rehuest
                .anyRequest().authenticated()               // any other requeste,, it needs to be authenticated
                .and()
                .formLogin() //allows to set for our login page
                .loginPage("/login")  // is the login page when users can login
                .permitAll()   // for all users, we are not hiding it
                .and() // add and if they want to logout
                .logout()
                .permitAll(); // we can have them logout
    }

    @Bean
    @Override
  public UserDetailsService userDetailsService(){ // allows us to set up user details and returns user details
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);

    }


}

