package com.shoestore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import com.shoestore.service.impl.UserSecurityService;
import com.shoestore.utility.SecurityUtility;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Environment env;
	
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserSecurityService();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider =  new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		return authProvider;
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	
	
	
	
	
	private static final String [] PUBLIC_MATCHERS= {
			"/css/**",
			"/js/**",
			"/image/**",
			"/",
			"/login",
			"/about",
			"/contact",
			"/newReleases",
			"/basketBallShoes",
			"/productPage",
			"/runningShoes",
			"/skateShoes",
	};
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests().
			/*antMatchers("/**").*/
			antMatchers(PUBLIC_MATCHERS).
			permitAll().anyRequest().authenticated();
		
		
			http
				.csrf().disable().cors().disable()
				.formLogin().failureUrl("/login?error")
				.defaultSuccessUrl("/profile")
				.loginPage("/login").permitAll()
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
				.and()
				.rememberMe();
				
		
	}
	
	
	
	
}