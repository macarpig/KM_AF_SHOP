package me.cloverclub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.mapper.ShopMapper;
import me.cloverclub.vo.CartVO;
import me.cloverclub.vo.ShopVO;

@Log4j
@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {
   private ShopMapper mapper;

   @Override
   public List<ShopVO> show() throws Exception {
      return mapper.show();
   }

   @Override
   public List<ShopVO> showRecent() throws Exception {
      return mapper.showRecent();
   }

   @Override
   public List<ShopVO> showHot() throws Exception {
      return mapper.showHot();
   }

   @Override
   public List<ShopVO> list(int cateCode) throws Exception {
      return mapper.list(cateCode);
   }

   @Override
   public ShopVO product(String gdsCode) throws Exception {
      return mapper.product(gdsCode);
   }

   @Override
   public void addCart(String userId, int gdsCode, int cartStock) throws Exception {
      mapper.addCart(userId, gdsCode, cartStock);
   }

   @Override
   public List<CartVO> showCart(String userId) throws Exception {
      return mapper.showCart(userId);
   }

@Override
public void deleteCart(CartVO cart) throws Exception {
	mapper.deleteCart(cart);
}
}