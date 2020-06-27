package me.cloverclub.mapper;

import java.util.List;

import me.cloverclub.vo.CartVO;
import me.cloverclub.vo.MemberVO;
import me.cloverclub.vo.OrderDetailVO;
import me.cloverclub.vo.OrderListVO;
import me.cloverclub.vo.OrderVO;
import me.cloverclub.vo.ShopVO;

public interface ShopMapper {
   
    //��� ��ǰ����� ���
      public List<ShopVO> show() throws Exception;
      
      //�ֽż����� 3���� ��ǰ�� ���
      public List<ShopVO> showRecent() throws Exception;
      
      //��ȸ������ 3���� ��ǰ�� ���
      public List<ShopVO> showHot() throws Exception;
      
      //ī�װ� ���ÿ� ���� ��ǰ����� �����
      public List<ShopVO> list(int cateCode) throws Exception;

      //��ǰ ���� �� ����� ��ǰ�� ���� �͵�
      public ShopVO product(String gdsCode) throws Exception;
      
      //��ȸ�� ����
      public void viewUp(String gdsCode) throws Exception;

      //��ٱ��Ͽ� ��ǰ�� �߰�
      public void addCart(CartVO cart) throws Exception;
      
      //��ٱ��� ������
      public List<CartVO> showCart(String userId) throws Exception;
      
      //īƮ ���� ����
      public void deleteCart(CartVO cart) throws Exception;
      
      //īƮ ��ǰ �ϳ� �߰�
      public void plusCart(CartVO cart) throws Exception;
      
    //īƮ ��ǰ �ϳ� ����
      public void removeCart(CartVO cart) throws Exception;
      
      //�ֹ����� ����
      public List<OrderListVO> orderView(OrderListVO order) throws Exception;
      
    //����ֹ� �Է�
      public void orderInfo(OrderVO order) throws Exception;
      
      //����ֹ��� �ֹ���ǰ ��� �Է�
      public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;

}