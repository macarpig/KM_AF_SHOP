package me.cloverclub.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import me.cloverclub.vo.MemberVO;

public interface MemberService {
	// login
	public MemberVO login(MemberVO vo) throws Exception;
	
	// logout
	public void logout(HttpSession session) throws Exception;
	
	// join
	public void join(MemberVO vo) throws Exception;
	
	//update
	public void update(MemberVO vo) throws Exception;
	
	// viewMember
	public MemberVO viewMember(String userId) throws Exception;
	
	// list
	public List<MemberVO> list() throws Exception;
}
