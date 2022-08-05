package com.vote.config;

import com.vote.controller.filter.JwtFilter;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final JwtFilter filter;

  public SecurityConfig(JwtFilter filter) {
    this.filter = filter;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // Enable CORS and disable CSRF
    http = http.cors().and().csrf().disable();

    // Set session management to stateless
    http = http
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and();

    // Set unauthorized requests exception handler
    http = http
        .exceptionHandling()
        .authenticationEntryPoint(
            (request, response, ex) -> {
              response.sendError(
                  HttpServletResponse.SC_UNAUTHORIZED,
                  ex.getMessage()
              );
            }
        )
        .and();

    // Set permissions on endpoints
    http.authorizeRequests()
        .antMatchers(HttpMethod.POST, "/voting/users/registration",
            "/api/v1/users/login").permitAll()
        .antMatchers(HttpMethod.GET, "/voting/users/me").authenticated()
        .antMatchers(HttpMethod.POST,"/voting/users").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET,"/voting/users/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT,"/voting/users/**").hasRole("ADMIN")

        .antMatchers(HttpMethod.POST, "/candidate").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/candidate").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/candidate/**").permitAll()

        .antMatchers(HttpMethod.POST, "/party").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/party").hasRole("ADMIN")
        .antMatchers(HttpMethod.GET, "/party/**").permitAll()

        .antMatchers(HttpMethod.GET, "/vote/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.POST, "/vote/registration").hasRole("USER")

        .anyRequest().authenticated();

    // Add JWT token filter
    http.addFilterBefore(
        filter,
        UsernamePasswordAuthenticationFilter.class
    );
  }
}