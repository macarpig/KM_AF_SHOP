package me.cloverclub.service;

import java.util.List;

import me.cloverclub.vo.GoodsVO;

public interface AdminService {
	// add goods
	public void goodsAdd(GoodsVO vo) throws Exception;
	
	// list goods
	public List<GoodsVO> goodsList() throws Exception;
}
