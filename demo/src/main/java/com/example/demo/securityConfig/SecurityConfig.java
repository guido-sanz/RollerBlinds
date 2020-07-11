package com.example.demo.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.service.UserService;
import com.example.demo.util.Passgenerator;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;
	
	String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder by = new BCryptPasswordEncoder();
		auth.userDetailsService(userService).passwordEncoder(by);

	}

	@Override
	protected void configure(HttpSecurity HTTP) throws Exception {
		HTTP
		.authorizeRequests()
		.antMatchers(resources).permitAll() 
		.antMatchers("/","/index").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
        .loginPage("/formulario")
        .permitAll()
        .defaultSuccessUrl("/Clientes")
        .failureUrl("/formulario?error=true")
        .usernameParameter("user")
        .passwordParameter("password")
      .and()
      .logout()
      .permitAll()
      .logoutSuccessUrl("/formulario?logout");

	}

}
