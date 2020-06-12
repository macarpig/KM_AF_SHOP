package me.cloverclub.mapper;

import javax.servlet.http.HttpSession;

import me.cloverclub.vo.MemberVO;

public interface MemberMapper {
	// login
	public MemberVO login(MemberVO vo) throws Exception;
	
	// join
	public void join(MemberVO vo) throws Exception;
}
