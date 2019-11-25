package com.clarivate.test.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.clarivate.test.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailService;
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .httpBasic()
		.and()
		.csrf().disable()
		.authorizeRequests().antMatchers(HttpMethod.POST, Constants.LOGIN_URL).permitAll()
		.anyRequest().authenticated().and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication()
    		.withUser("user1").password("{noop}password1").roles("USER")
        	.and()
    		.withUser("user2").password("{noop}password2").roles("USER")
        	.and()
    		.withUser("user3").password("{noop}password3").roles("USER")
        	.and()
        	.withUser("user4").password("{noop}password4").roles("USER");        
        auth.userDetailsService(userDetailService);
        
    }	
    
	
}
