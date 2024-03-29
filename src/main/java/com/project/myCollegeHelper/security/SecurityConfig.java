package com.project.myCollegeHelper.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/oauth2/**", "/subject/**", "/grades/**","https://ucilnica.fri.uni-lj.si/**", "/student/**", "/api/**")
                .permitAll()
                .antMatchers("/", "/subject/**", "/grades/**", "/student/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .oauth2Login()
                    .defaultSuccessUrl("/")
                    .failureUrl("/login")
                .loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll().logoutSuccessUrl("/login");
    }

}