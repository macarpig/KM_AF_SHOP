package me.cloverclub.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.service.AdminService;
import me.cloverclub.service.CategoryService;
import me.cloverclub.util.UploadFileUtil;
import me.cloverclub.vo.CategoryVO;
import me.cloverclub.vo.GoodsVO;
import net.sf.json.JSONArray;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	private AdminService a_service;
	private CategoryService c_service;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	// get admin index
	@GetMapping("/index")
	public String getIndex() {
		log.info("AdminController: getIndex()");
		
		return "/admin/index";
	}
	
	// get goods list
	@GetMapping("/goods/list")
	public String getGoodsList(Model model) throws Exception {
		log.info("AdminController: getGoodsList()");
		
		List<GoodsVO> list = a_service.goodsList();
		model.addAttribute("list", list);
		
		return "/admin/goods/list";
	}
	
	// get goods add
	@GetMapping("/goods/add")
	public String getGoodsAdd(Model model) throws Exception {
		log.info("AdminController: getGoodsAdd()");
		
		List<CategoryVO> category = null;
		category = c_service.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		
		return "/admin/goods/add";
	}
	
	// post goods add
	@PostMapping("/goods/add")
	public String postGoodsAdd(GoodsVO vo, MultipartFile file) throws Exception {
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtil.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file != null) {
			fileName = UploadFileUtil.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		}
		
		else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}
		
		vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		
		a_service.goodsAdd(vo);
		
		return "redirect:/admin/goods/add";
	}
}