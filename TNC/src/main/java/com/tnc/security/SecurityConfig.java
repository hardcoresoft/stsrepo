package com.tnc.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebSecurity
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		    .antMatchers("/resources/**", "/images/**", "/js/**", "/css/**").permitAll()                  
			.antMatchers("/admin/**").access("hasRole('ADMIN')")
			.antMatchers("/booking/**").hasRole("USER")
			.antMatchers("/contact/**").hasRole("ADMIN")
//			.anyRequest().authenticated();
			.anyRequest().anonymous();
			
		
		http.formLogin()
			.loginPage("/login").permitAll()
			.failureUrl("/login?error")
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
			.logout().permitAll()
			.logoutSuccessUrl("/login?logout")
			.and()
			.csrf();

//		 http
//		 .authorizeRequests()
//		 .antMatchers("/").permitAll()
//		 .antMatchers("/contact/**").hasRole("USER")
//		 .antMatchers("/admin/**").hasRole("ADMIN")
//		 .anyRequest().authenticated();
//		 //.anyRequest().anonymous();
//		 
//		 http
//		 .formLogin()
//		 .loginPage("/login").permitAll()
//		 .and()
//		 .logout().permitAll()
//		 .logoutSuccessUrl("/login?logout")
//		 .and()
//		 .csrf();
//		 ;
	
	}
	
	
	@Configuration
	protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

		@Autowired
		private DataSource dataSource;

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			
			auth.jdbcAuthentication()
				.dataSource(dataSource)
				.withUser("user").password("password").roles("USER").and()
				.withUser("admin").password("password").roles("USER", "ADMIN")
				;
		}

	}

}
