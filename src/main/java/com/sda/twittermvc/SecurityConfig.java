package com.sda.twittermvc;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //
        http.authorizeRequests().anyRequest().permitAll().and()
                .authorizeRequests().antMatchers("/secured")
                .authenticated()
                .and()
                .csrf().disable();  //autoryzuj req
    }
}
