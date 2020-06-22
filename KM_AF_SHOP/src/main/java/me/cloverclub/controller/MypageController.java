package me.cloverclub.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.service.MemberService;
import me.cloverclub.vo.MemberVO;

@Controller
@Log4j
public class MypageController {

	@Inject
	private MemberService service;
	
	@RequestMapping(value = "/mypage")
	public String getMypage() throws Exception {
		log.info("getMypage()");
		
		return "mypage";
	}
	
	@RequestMapping(value = "/memberInfo", method = RequestMethod.GET)
	public String getMemberInfo() throws Exception {
		return "memberInfo";
	}
	
	@RequestMapping(value = "/orderList")
	public String getOrderlist() throws Exception {
		log.info("getOrderList()");
		
		return "orderList";
	}
}
