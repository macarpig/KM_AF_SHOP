package me.cloverclub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.service.AdminService;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	private AdminService service;
	
	@GetMapping("index")
	public String getIndex() {
		log.info("AdminController: getIndex()");
		
		return "/admin/index";
	}
	
	@GetMapping("goods/add")
	public String getGoodsAdd() {
		log.info("AdminController: getGoodsAdd()");
		
		return "/admin/add";
	}
}
