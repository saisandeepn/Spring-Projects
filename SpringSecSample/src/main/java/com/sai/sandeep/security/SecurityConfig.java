package com.sai.sandeep.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sai.sandeep.dao.UserDao;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled= true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		/**
		 * In Memory Authentication
		 * auth
		 * .inMemoryAuthentication()
		 * .withUser("user").password("password").roles("USER")
		 * .and()
		 * .withUser("admin").password("password").roles("USER","ADMIN");
		 * /
		 		
		
		/**
		 * Using JDBC authentication
		 * auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(bcryptEncoder);
		 */
		
		/**
		 * 
		 */
		
		auth.userDetailsService(userDao).passwordEncoder(bcryptEncoder);
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

			
		// the wildcard characters **/ ** represents that any URL which has
		// admin is secured. In the above example we only used
		// security for admin page ONLY
		// .antMatchers("/admin**/**")

	}
}
