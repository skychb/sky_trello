package trello.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import trello.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	@Qualifier("customUserDetailService")
	private CustomUserDetailService customUserDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**", "/resources/**", "/webjars/**")
				.permitAll();
		http.authorizeRequests().antMatchers("/project").anonymous().antMatchers(HttpMethod.GET, "/").authenticated()
				.and().formLogin().loginPage("/login").loginProcessingUrl("/login").failureUrl("/login")
				.usernameParameter("userId").passwordParameter("password").defaultSuccessUrl("/project").and().logout()
				.logoutSuccessUrl("/");
	}

	// @secured("ROLE_USER") 이런식으로 각RequestMap 에 넣을 수 있다.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(customUserDetailsService);

		// In case of password encryption - for production site
		// auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	};
}