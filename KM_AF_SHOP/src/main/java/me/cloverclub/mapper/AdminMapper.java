package me.cloverclub.mapper;

import java.util.List;

import me.cloverclub.vo.GoodsVO;

public interface AdminMapper {
	// add goods
	public int goodsAdd(GoodsVO vo) throws Exception;
	
	// list goods
	public List<GoodsVO> goodsList() throws Exception;
}
