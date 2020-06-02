package me.cloverclub.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.mapper.AdminMapper;
import me.cloverclub.vo.GoodsVO;

@Log4j
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
	private AdminMapper mapper;
	
	@Override
	public void goodsAdd(GoodsVO vo) throws Exception {
		log.info("AdminService: goodsAdd()");
		
		mapper.goodsAdd(vo);
	}

}
