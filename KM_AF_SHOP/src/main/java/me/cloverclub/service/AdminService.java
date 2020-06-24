package me.cloverclub.service;

import java.util.List;

import me.cloverclub.vo.GoodsVO;
import me.cloverclub.vo.OrderVO;
import me.cloverclub.vo.ShopVO;

public interface AdminService {
	// add goods
	public void goodsAdd(GoodsVO vo) throws Exception;
	
	// view goods
	public ShopVO goodsView(String gdsCode) throws Exception;
	
	// list goods
	public List<ShopVO> goodsList() throws Exception;
	
	// modify goods
	public void goodsModify(GoodsVO vo) throws Exception;
	
	// delete goods
	public void goodsDelete(String gdsCode) throws Exception;
	
}
