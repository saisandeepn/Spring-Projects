package com.sai.sandeep.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		//In Memeory Authentication
		/*		auth
		.inMemoryAuthentication()
		.withUser("user").password("password").roles("USER")
		.and()
		.withUser("admin").password("password").roles("USER","ADMIN");*/
		
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	public void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
		.and()
		.httpBasic();
	}
}
