package me.cloverclub.mapper;

import java.util.List;

import me.cloverclub.vo.CartVO;
import me.cloverclub.vo.MemberVO;
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
      
      //��ٱ��Ͽ� ��ǰ�� �߰�
      public void addCart(String userId, int gdsCode, int cartStock) throws Exception;
      
      //��ٱ��� ������
      public List<CartVO> showCart(String userId) throws Exception;
}