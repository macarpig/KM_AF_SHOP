package me.cloverclub.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.service.AdminService;
import me.cloverclub.service.CategoryService;
import me.cloverclub.vo.CategoryVO;
import net.sf.json.JSONArray;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	private AdminService a_service;
	private CategoryService c_service;
	
	@GetMapping("/index")
	public String getIndex() {
		log.info("AdminController: getIndex()");
		
		return "/admin/index";
	}
	
	@GetMapping("/goods/add")
	public String getGoodsAdd(Model model) throws Exception {
		log.info("AdminController: getGoodsAdd()");
		
		List<CategoryVO> category = null;
		category = c_service.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		
		return "/admin/add";
	}
}