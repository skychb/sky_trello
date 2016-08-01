package trello.configure;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

import trello.service.CustomResourceServerTokenServices;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurity extends WebSecurityConfigurerAdapter {
	@Resource(name = "customUserDetailService")
	private UserDetailsService customUserDetailService;

	@Autowired
	private ResourceServerProperties sso;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();

		http.authorizeRequests().antMatchers(HttpMethod.GET, "/project/**").authenticated().antMatchers("/project")
				.access("hasRole(ROLE_USER)").anyRequest().permitAll().and().formLogin().loginPage("/login")
				.loginProcessingUrl("/login").permitAll().and().logout().permitAll();

		http.httpBasic();
	}

	@Bean
	public ResourceServerTokenServices userInfoTokenServices() {
		return new CustomResourceServerTokenServices(sso.getUserInfoUri(), sso.getClientId());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

// @Configuration
// @EnableWebSecurity
// @EnableOAuth2Sso
// public class WebSecurity extends WebSecurityConfigurerAdapter {
//// @Autowired
//// @Qualifier("customUserDetailService")
//// private CustomUserDetailService customUserDetailsService;
// @Resource(name = "customerUserDetailsService")
// private UserDetailsService customUserDetailsService;
//
// @Autowired
// private ResourceServerProperties sso;
//
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http.csrf().disable();
// http.headers().frameOptions().disable();
// http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**",
// "/resources/**", "/webjars/**")
// .permitAll();
// http.authorizeRequests().antMatchers(HttpMethod.GET,
// "/project/**").authenticated()
// .antMatchers("/project").access("hasRole(ROLE_USER)")
// .anyRequest().permitAll()
// .and()
// .formLogin().loginPage("/login").loginProcessingUrl("/login").permitAll()
// .and()
// .logout().permitAll();
// http.httpBasic();
//// http.authorizeRequests().antMatchers("/project").anonymous().antMatchers(HttpMethod.GET,
// "/").authenticated()
//// .and().formLogin().loginPage("/login").loginProcessingUrl("/login").failureUrl("/login")
//// .usernameParameter("userId").passwordParameter("password").defaultSuccessUrl("/project").and().logout()
//// .logoutSuccessUrl("/");
// }
//
// // @secured("ROLE_USER") 이런식으로 각RequestMap 에 넣을 수 있다.
// @Override
// protected void configure(AuthenticationManagerBuilder auth) throws Exception
// {
//
//// auth.userDetailsService(customUserDetailsService);
//
// // In case of password encryption - for production site
// auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
// }
//
// @Bean
// public ResourceServerTokenServices userInfoTokenServices() {
// return new CustomResourceServerTokenServices(sso.getUserInfoUri(),
// sso.getClientId());
// }
//
// @Bean
// public PasswordEncoder passwordEncoder(){
// return new BCryptPasswordEncoder();
// };
// }