package me.cloverclub.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class MemberController {
	// private MemberService service;
	
	BCryptPasswordEncoder passEncoder;
	
	@GetMapping("/login")
	public String getLogin() {
		log.info("getLogin()");
		
		return "login";
	}
	
	@GetMapping("/join")
	public String getJoin() {
		log.info("getJoin()");
		
		return "join";
	}
}
