package me.cloverclub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.mapper.ShopMapper;
import me.cloverclub.vo.CartVO;
import me.cloverclub.vo.OrderDetailVO;
import me.cloverclub.vo.OrderListVO;
import me.cloverclub.vo.OrderVO;
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
   public void addCart(CartVO cart) throws Exception {
      mapper.addCart(cart);
   }

   @Override
   public List<CartVO> showCart(String userId) throws Exception {
      return mapper.showCart(userId);
   }

@Override
public void deleteCart(CartVO cart) throws Exception {
   mapper.deleteCart(cart);
}

@Override
public void plusCart(CartVO cart) throws Exception {
   mapper.plusCart(cart);
}

@Override
public void removeCart(CartVO cart) throws Exception {
   mapper.removeCart(cart);
}

@Override
// orderList view
public List<OrderListVO> orderView(OrderListVO order) throws Exception {
   
   return mapper.orderView(order);
}

@Override
public void orderInfo(OrderVO order) throws Exception {
   mapper.orderInfo(order);
}

@Override
public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
   mapper.orderInfo_Details(orderDetail);
}

@Override
public void viewUp(String gdsCode) throws Exception {
   mapper.viewUp(gdsCode);
}
}