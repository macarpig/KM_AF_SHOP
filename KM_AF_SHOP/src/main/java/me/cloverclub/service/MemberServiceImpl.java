package me.cloverclub.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.mapper.MemberMapper;
import me.cloverclub.vo.MemberVO;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	private MemberMapper mapper;

	// login
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		log.info("MemberService: login()");
		return mapper.login(vo);
	}
	
	//login
	

	// logout
	@Override
	public void logout(HttpSession session) throws Exception {
		log.info("MemberService: logout()");
		
		session.invalidate();
	}
	
	// join
	@Override
	public void join(MemberVO vo) throws Exception {
		log.info("MemberService: join()");
		
		mapper.join(vo);
	}
	
	// update
	@Override
	public void update(MemberVO vo) throws Exception {
		log.info("MemberService: update()");
		
		mapper.update(vo);
	}
	
	//viewMember
	@Override
	public MemberVO viewMember(String userId) throws Exception {
		log.info("MemberService: viewMember()");
		
		return mapper.viewMember(userId);
	}

	// list
	@Override
	public List<MemberVO> list() throws Exception {
		log.info("MemberService: list()");
		
		return mapper.list();
	}
}
