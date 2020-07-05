package me.cloverclub.mapper;

import java.util.List;

import me.cloverclub.vo.AdminorderVO;
import me.cloverclub.vo.GoodsVO;
import me.cloverclub.vo.OrderListVO;
import me.cloverclub.vo.PickingVO;
import me.cloverclub.vo.ProcessVO;
import me.cloverclub.vo.ShopVO;

public interface AdminMapper {
	// add goods
	public int goodsAdd(GoodsVO vo) throws Exception;
	
	// view goods
	public ShopVO goodsView(String gdsCode) throws Exception;
	
	// list goods
	public List<ShopVO> goodsList() throws Exception;
	
	// modify goods
	public void goodsModify(GoodsVO vo) throws Exception;
	
	// delete goods
	public void goodsDelete(String gdsCode) throws Exception;
	
	//order list
	public List<AdminorderVO> orderView() throws Exception;
	
	//picking list
	public List<PickingVO> pickingView() throws Exception;
	
	//picking complete
	public void pickingUpdate(ProcessVO vo) throws Exception;
}
