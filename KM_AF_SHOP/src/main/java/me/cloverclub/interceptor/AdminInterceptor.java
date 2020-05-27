package me.cloverclub.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import me.cloverclub.vo.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		if(member == null) {
			response.sendRedirect("/login");
			
			return false;
		}
		
		if(member.getUserAuth() != 1) {
			response.sendRedirect("/");
			
			return false;
		}
		
		return true;
	}
}
