package com.project.myCollegeHelper;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/oauth2/**")
                .permitAll()
                .antMatchers("/").authenticated()
                .anyRequest().permitAll()
                .and()
                .oauth2Login()
                    .defaultSuccessUrl("/")
                    .failureUrl("/bye")
                .loginPage("/login");
    }

}