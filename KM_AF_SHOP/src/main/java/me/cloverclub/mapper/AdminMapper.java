package me.cloverclub.mapper;

import me.cloverclub.vo.GoodsVO;

public interface AdminMapper {
	// add goods
	public int goodsAdd(GoodsVO vo) throws Exception;
}
