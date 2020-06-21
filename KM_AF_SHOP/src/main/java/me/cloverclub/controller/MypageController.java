package me.cloverclub.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.service.MemberService;

@Controller
@Log4j
@AllArgsConstructor
public class MypageController {

	@GetMapping("/mypage")
	public String getMypage() {
		log.info("getMypage()");
		
		return "mypage";
	}
}
