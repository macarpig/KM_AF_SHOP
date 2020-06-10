package me.cloverclub.mapper;

import java.util.List;

import me.cloverclub.vo.GoodsVO;
import me.cloverclub.vo.ShopVO;

public interface AdminMapper {
	// add goods
	public int goodsAdd(GoodsVO vo) throws Exception;
	
	// view goods
	public ShopVO goodsView(String gdsCode) throws Exception;
	
	// list goods
	public List<GoodsVO> goodsList() throws Exception;
}
