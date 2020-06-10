package me.cloverclub.service;

import java.util.List;

import me.cloverclub.vo.CartVO;
import me.cloverclub.vo.ShopVO;

public interface ShopService {
   
    public List<ShopVO> show() throws Exception;
      
      public List<ShopVO> showRecent() throws Exception;
      
      public List<ShopVO> showHot() throws Exception;
      
      public List<ShopVO> list(int cateCode) throws Exception;
      
      public ShopVO product(String gdsCode) throws Exception;
      
      public void addCart(String userId, int gdsCode, int cartStock) throws Exception;
      
      public List<CartVO> showCart(String userId) throws Exception;
}