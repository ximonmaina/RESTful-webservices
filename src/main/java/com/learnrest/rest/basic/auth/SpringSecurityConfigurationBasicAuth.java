package com.learnrest.rest.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // enable spring configuration
@EnableWebSecurity // enable spring security configuration
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
               .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll() // permit http method requests on all urls but authenticate all other urls
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // use http basic authentication
    }
}
