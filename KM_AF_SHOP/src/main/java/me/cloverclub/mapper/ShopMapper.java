package me.cloverclub.mapper;

import java.util.List;

import me.cloverclub.vo.MemberVO;
import me.cloverclub.vo.ShopVO;

public interface ShopMapper {
	
	 //모든 상품목록을 띄움
	   public List<ShopVO> show() throws Exception;
	   
	   //최신순으로 3개만 상품을 띄움
	   public List<ShopVO> showRecent() throws Exception;
	   
	   //조회순으로 3개만 상품을 띄움
	   public List<ShopVO> showHot() throws Exception;
	   
	   //카테고리 선택에 따라서 상품목록이 띄워짐
	   public List<ShopVO> list(int cateCode) throws Exception;

}
