package me.cloverclub.mapper;

import java.util.List;

import me.cloverclub.vo.CartVO;
import me.cloverclub.vo.MemberVO;
import me.cloverclub.vo.OrderDetailVO;
import me.cloverclub.vo.OrderListVO;
import me.cloverclub.vo.OrderVO;
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

      //상품 선택 후 띄워질 상품에 대한 것들
      public ShopVO product(String gdsCode) throws Exception;
      
      //조회수 증가
      public void viewUp(String gdsCode) throws Exception;

      //장바구니에 상품이 추가
      public void addCart(CartVO cart) throws Exception;
      
      //장바구니 보여짐
      public List<CartVO> showCart(String userId) throws Exception;
      
      //카트 선택 삭제
      public void deleteCart(CartVO cart) throws Exception;
      
      //카트 상품 하나 추가
      public void plusCart(CartVO cart) throws Exception;
      
    //카트 상품 하나 제거
      public void removeCart(CartVO cart) throws Exception;
      
      //주문내역 보기
      public List<OrderListVO> orderView(OrderListVO order) throws Exception;
      
    //배송주문 입력
      public void orderInfo(OrderVO order) throws Exception;
      
      //배송주문의 주문상품 목록 입력
      public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;

}