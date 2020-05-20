package me.cloverclub.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import me.cloverclub.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sql;
	
	private static String namespace = "me.cloverclub.mapper.MemberMapper";
	
	// login
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return sql.selectOne(namespace + ".login", vo);
	}

	// join
	@Override
	public void join(MemberVO vo) throws Exception {
		sql.insert(namespace + ".join", vo);
	}
}
