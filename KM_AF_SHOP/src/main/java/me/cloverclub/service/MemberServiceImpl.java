package me.cloverclub.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import me.cloverclub.persistence.MemberDAO;
import me.cloverclub.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao;

	// login
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return dao.login(vo);
	}

	// logout
	@Override
	public void logout(HttpSession session) throws Exception {
		session.invalidate();
	}
	
	// join
	@Override
	public void join(MemberVO vo) throws Exception {
		dao.join(vo);
	}
}
