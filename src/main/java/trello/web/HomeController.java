package trello.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping("")
	public String home() {
		return "index";
	}

	@RequestMapping(value="/signUp", method={RequestMethod.GET, RequestMethod.POST})
	public String signUp() {
		return "signUp";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/page")
	public String page() {
		return "page";
	}

}
