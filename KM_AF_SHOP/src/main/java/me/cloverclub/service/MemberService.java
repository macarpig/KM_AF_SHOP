package me.cloverclub.service;

import javax.servlet.http.HttpSession;

import me.cloverclub.vo.MemberVO;

public interface MemberService {
	// login
	public MemberVO login(MemberVO vo) throws Exception;
	
	// logout
	public void logout(HttpSession session) throws Exception;
	
	// join
	public void join(MemberVO vo) throws Exception;
}
