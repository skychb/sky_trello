package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@RequestMapping("")
	public String moveHome() {
		return "index";
	}

	@RequestMapping("/signUp")
	public String signUp() {
		return "signUp";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/projectMain")
	public String projectMain() {
		return "projectMain";
	}

	@RequestMapping("/board")
	public String board() {
		return "board";
	}

}