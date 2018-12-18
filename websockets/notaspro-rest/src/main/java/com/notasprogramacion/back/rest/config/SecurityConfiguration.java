package com.notasprogramacion.back.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//enable anootation @PreAuthorize
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;

	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().anyRequest().hasRole("ADMIN").and().formLogin()
		.permitAll().and().sessionManagement().maximumSessions(1);
		//http.authorizeRequests().antMatchers("/css/*", "/imgs/*").permitAll().anyRequest().authenticated();
		/*
		http.authorizeRequests().antMatchers("/css/*", "/imgs/*").permitAll().anyRequest().authenticated().and()
				.formLogin().loginPage("/login").loginProcessingUrl("/logincheck").usernameParameter("username")
				.passwordParameter("password").defaultSuccessUrl("/loginsuccess").permitAll().and().logout()
				.logoutUrl("/logout").logoutSuccessUrl("/login?logout").permitAll();
		*/

	}

}
