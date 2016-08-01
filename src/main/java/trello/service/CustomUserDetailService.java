package trello.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import trello.domain.user.TrelloUser;
import trello.domain.user.TrelloUserRepository;
import org.springframework.security.core.userdetails.User;

@Service("customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserDetailService.class);
	
	@Autowired
	private TrelloUserRepository userRepository;

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TrelloUser user = userRepository.findByUserId(username);
		java.util.List<GrantedAuthority> authorities = buildUserAuthority();
		return buildUserForAuthentication(user, authorities);
	}
	
	private User buildUserForAuthentication(TrelloUser user, java.util.List<GrantedAuthority> authorities) {
		return new User(user.getUserId(), user.getPassword(),
				true, true, true, true, authorities);
	}
	
	private java.util.List<GrantedAuthority> buildUserAuthority() {
		java.util.List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(0);
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authorities;
	}
}