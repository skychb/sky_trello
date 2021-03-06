package trello.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import trello.domain.user.TrelloUser;
import trello.domain.user.TrelloUserRepository;
import trello.domain.user.User;

@Controller
public class UserController {
	@Autowired
	private TrelloUserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value="/loginform", method = RequestMethod.GET)
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String SignupPage(){
		return "signUp";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public String signup(TrelloUser user){
		System.out.println("user" + user);
		user.encodePassword(passwordEncoder);
		userRepository.save(user);
		return "redirect:/";
	}
	
//	@RequestMapping(value="/login", method = RequestMethod.POST)
//	public String login(@RequestParam String userId, @RequestParam String userPassword, HttpServletRequest request){
//		User user = userRepository.findByUserId(userId);
//		
////		System.out.println(user);
//		request.getSession().setAttribute("user", user);
//		return "redirect:/project";
//	}
}
