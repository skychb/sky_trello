package trello.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
//		http
//		.authorizeRequests()
//			.antMatchers(HttpMethod.GET, "/").authenticated()
//			.antMatchers(HttpMethod.POST).access()
	}
	//@secured("ROLE_USER") 이런식으로 각RequestMap 에 넣을 수 있다. 
	
}