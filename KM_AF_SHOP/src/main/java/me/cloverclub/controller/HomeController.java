package me.cloverclub.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.service.CategoryService;
import me.cloverclub.service.ShopService;
import me.cloverclub.vo.CategoryVO;
import me.cloverclub.vo.ShopVO;
import net.sf.json.JSONArray;

@Controller
@Log4j
@AllArgsConstructor
public class HomeController {
	
	private ShopService s_service;
	   private CategoryService c_service;
	   
	   @GetMapping("/")
	   public String getIndex(Model model) throws Exception {
	      log.info("getIndex()");
	      List<ShopVO> recent = null;
	      List<ShopVO> hot = null;
	      recent = s_service.showRecent();
	      recent = s_service.showHot();
	      
	      model.addAttribute("showRecent", recent);
	      model.addAttribute("showHot", hot);
	      
	      return "index";
	   }   
	   
	   @GetMapping("/shop")
	   public void getShop(@RequestParam("c") int cateCode, @RequestParam("l") int level, Model model) throws Exception {
	      List<CategoryVO> category = null;
	      List<ShopVO> list = null;
	      category = c_service.category();
	      if(cateCode==0&level==0) {
	    	  list = s_service.show();
	      }else {
	    	  list = s_service.list(cateCode);
	      }
	      
	      model.addAttribute("category", JSONArray.fromObject(category));
	      model.addAttribute("list", list);
	   }
	   
	   @GetMapping("/product")
	   public String getProduct()
	   {
	      return "product";
	   }

}