package me.cloverclub.service;

import java.util.List;

import me.cloverclub.vo.CartVO;
import me.cloverclub.vo.OrderDetailVO;
import me.cloverclub.vo.OrderListVO;
import me.cloverclub.vo.OrderVO;
import me.cloverclub.vo.PayVO;
import me.cloverclub.vo.ShopVO;

public interface ShopService {
   
    public List<ShopVO> show() throws Exception;
      
      public List<ShopVO> showRecent() throws Exception;
      
      public List<ShopVO> showHot() throws Exception;
      
      public List<ShopVO> list(int cateCode) throws Exception;
      
      public ShopVO product(String gdsCode) throws Exception;
      
      public void viewUp(String gdsCode) throws Exception;
      
      public void addCart(CartVO cart) throws Exception;
      
      public List<CartVO> showCart(String userId) throws Exception;
      
      public void deleteCart(CartVO cart) throws Exception;
      
      public void plusCart(CartVO cart) throws Exception;
      
      public void removeCart(CartVO cart) throws Exception;
      
     // orderList view
      public List<OrderListVO> orderView(OrderListVO order) throws Exception;
      
      //주문 정보 삽입
      public void orderInfo(OrderVO order) throws Exception;
      
      //주문 상세 정보 삽입
      public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;
      
      public void orderInsert(String orderId) throws Exception;
      
      public void cartAllDelete(String userId) throws Exception;
      
      public void addPay(PayVO pay) throws Exception;
}