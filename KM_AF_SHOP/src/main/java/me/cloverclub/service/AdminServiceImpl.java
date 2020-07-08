package me.cloverclub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.mapper.AdminMapper;
import me.cloverclub.mapper.ShopMapper;
import me.cloverclub.vo.AdminorderVO;
import me.cloverclub.vo.GoodsVO;
import me.cloverclub.vo.OrderVO;
import me.cloverclub.vo.PickingVO;
import me.cloverclub.vo.ProcessVO;
import me.cloverclub.vo.ShopVO;

@Log4j
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
	private AdminMapper mapper;
	private ShopMapper mapper2;
	
	// add goods
	@Override
	public void goodsAdd(GoodsVO vo) throws Exception {
		log.info("AdminService: goodsAdd()");
		
		mapper.goodsAdd(vo);
	}
	
	// view goods
	@Override
	public ShopVO goodsView(String gdsCode) throws Exception {
		log.info("AdminService: goodsView()");
		
		return mapper.goodsView(gdsCode);
	}

	// list goods
	@Override
	public List<ShopVO> goodsList() throws Exception {
		log.info("AdminService: goodsList()");
		
		return mapper.goodsList();
	}

	// modify goods
	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		log.info("AdminService: goodsModify()");
		
		mapper.goodsModify(vo);
	}

	// delete goods
	@Override
	public void goodsDelete(String gdsCode) throws Exception {
		log.info("AdminService: goodsDelete()");
		
		mapper.goodsDelete(gdsCode);
	}
	
	//order list
	@Override
	public List<AdminorderVO> orderView() throws Exception {
		log.info("AdminService: orderList()");
		
		return mapper.orderView();
	}
	
	//picking list0
	@Override
	public List<PickingVO> pickingView0() throws Exception {
		log.info("AdminService: pickingList()");
		
		return mapper.pickingView0();
	}
	
	//picking list1
		@Override
		public List<PickingVO> pickingView1() throws Exception {
			log.info("AdminService: pickingList()");
			
			return mapper.pickingView1();
		}
	
	//picking complete
	@Override
	public void pickingUpdate(ProcessVO process) throws Exception {
		log.info("AdminService: pickingComplete()");
		
		mapper.pickingUpdate(process);
	}
	
	//picking delete
		@Override
		public void pickingDelete(ProcessVO process) throws Exception {
			log.info("AdminService: pickingDelte()");
			
			mapper.pickingDelete(process);
		}

		@Override
		public void deliveryUpdate(AdminorderVO order) throws Exception {
			mapper.deliveryUpdate(order);
		}

		@Override
		public void deliveryComplete(AdminorderVO order) throws Exception {
			mapper.deliveryComplete(order);
		}

		@Override
		public List<AdminorderVO> deliveryView0() throws Exception {
			return mapper.deliveryView0();
		}

		@Override
		public List<AdminorderVO> deliveryView1() throws Exception {
			return mapper.deliveryView1();
		}

		@Override
		public void stockDown(ProcessVO process) throws Exception {
			mapper.stockDown(process);
		}

		@Override
		public void stockUp(ProcessVO process) throws Exception {
			mapper.stockUp(process);
		}

		@Override
		public void authUp(String userId) throws Exception {
			mapper.authUp(userId);
		}

		@Override
		public void authDown(String userId) throws Exception {
			mapper.authDown(userId);
		}
}
