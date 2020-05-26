package me.cloverclub.service;

import java.util.List;
import me.cloverclub.vo.ShopVO;

public interface ShopService {
	
	 public List<ShopVO> show() throws Exception;
	   
	   public List<ShopVO> showRecent() throws Exception;
	   
	   public List<ShopVO> showHot() throws Exception;
	   
	   public List<ShopVO> list(int cateCode, int level) throws Exception;
}
