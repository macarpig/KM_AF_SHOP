package me.cloverclub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.mapper.AdminMapper;
import me.cloverclub.mapper.ShopMapper;
import me.cloverclub.vo.GoodsVO;
import me.cloverclub.vo.OrderVO;
import me.cloverclub.vo.ShopVO;

@Log4j
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
	private AdminMapper mapper;
	private ShopMapper mapper2;
	
	// add goods
	@Override
	public void goodsAdd(GoodsVO vo) throws Exception {
		log.info("AdminService: goodsAdd()");
		
		mapper.goodsAdd(vo);
	}
	
	// view goods
	@Override
	public ShopVO goodsView(String gdsCode) throws Exception {
		log.info("AdminService: goodsView()");
		
		return mapper.goodsView(gdsCode);
	}

	// list goods
	@Override
	public List<ShopVO> goodsList() throws Exception {
		log.info("AdminService: goodsList()");
		
		return mapper.goodsList();
	}

	// modify goods
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		log.info("AdminService: goodsModify()");
		
		mapper.goodsModify(vo);
	}

	// delete goods
	@Override
	public void goodsDelete(String gdsCode) throws Exception {
		log.info("AdminService: goodsDelete()");
		
		mapper.goodsDelete(gdsCode);
	}
}
