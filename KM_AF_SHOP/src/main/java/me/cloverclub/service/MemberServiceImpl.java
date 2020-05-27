package me.cloverclub.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.mapper.MemberMapper;
import me.cloverclub.vo.MemberVO;

@Service
@Log4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	private MemberMapper mapper;

	// login
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		log.info("MemberService login()");
		
		return mapper.login(vo);
	}

	// logout
	@Override
	public void logout(HttpSession session) throws Exception {
		log.info("MemberService logout()");
		
		session.invalidate();
	}
	
	// join
	@Override
	public void join(MemberVO vo) throws Exception {
		log.info("MemberService join()");
		
		mapper.join(vo);
	}
}
