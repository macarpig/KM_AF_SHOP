package me.cloverclub.service;

import java.util.List;

import me.cloverclub.vo.AdminorderVO;
import me.cloverclub.vo.GoodsVO;
import me.cloverclub.vo.OrderListVO;
import me.cloverclub.vo.OrderVO;
import me.cloverclub.vo.PickingVO;
import me.cloverclub.vo.ProcessVO;
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
	
	// order list
	public List<AdminorderVO> orderView() throws Exception;
	
	//picking list
	public List<PickingVO> pickingView0() throws Exception;
	
	//picking list
	public List<PickingVO> pickingView1() throws Exception;
	
	//complete picking
	public void pickingUpdate(ProcessVO process) throws Exception;
	
	//picking delete
	public void pickingDelete(ProcessVO process) throws Exception;

	//delivery update
	public void deliveryUpdate(AdminorderVO order) throws Exception;
		
	//delivery complete
	public void deliveryComplete(AdminorderVO order) throws Exception;
	
	//delivery view0
	public List<AdminorderVO> deliveryView0() throws Exception;
		
	//delivery view0
	public List<AdminorderVO> deliveryView1() throws Exception;
	
	//stock down
	public void stockDown(ProcessVO process) throws Exception;
		
	//stock up
	public void stockUp(ProcessVO process) throws Exception;
	
	public void authUp(String userId) throws Exception;
	
	public void authDown(String userId) throws Exception;
}
