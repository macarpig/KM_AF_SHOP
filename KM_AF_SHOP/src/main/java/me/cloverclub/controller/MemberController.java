package me.cloverclub.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.service.MemberService;
import me.cloverclub.vo.MemberVO;

@Controller
@Log4j
@AllArgsConstructor
public class MemberController {
	private MemberService service;
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	@GetMapping("/login")
	public String getLogin() {
		log.info("getLogin()");
		
		return "login";
	}

	
	@PostMapping("/login")
	public String postLogin(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		
		MemberVO login = service.login(vo);
		HttpSession session = req.getSession();
		
		if(login!=null) {
		boolean loginMatch = passEncoder.matches(vo.getUserPw(), login.getUserPw());
		
		if(login!=null && loginMatch) {
			session.setAttribute("member", login);
			log.info("postLogin()" + login);
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			
			return "redirect:/login";
		}
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
			
			return "redirect:/login";
		}
		return "redirect:/";
	}
	
	@GetMapping("/join")
	public String getJoin() throws Exception {
		log.info("getJoin()");
		
		return "join";
	}
	
	@PostMapping("/join")
	public String postJoin(MemberVO vo) throws Exception {
		log.info("postJoin()" + vo);
		
		String userPw = vo.getUserPw();
		String encodePw = passEncoder.encode(userPw);
		vo.setUserPw(encodePw);
		
		service.join(vo);
		
		return "redirect:/";
	}
	
	@RequestMapping("logout") 
	public String logout(MemberVO vo,
			HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		log.info("logout()" + vo);
		HttpSession session = req.getSession();
		session.setAttribute("member", null);
		rttr.addFlashAttribute("msg", false);
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception {
		String userPw = vo.getUserPw();
		String encodePw = passEncoder.encode(userPw);
		vo.setUserPw(encodePw);
		
		service.update(vo);
		session.invalidate();
		return "redirect:/";
	}
}
