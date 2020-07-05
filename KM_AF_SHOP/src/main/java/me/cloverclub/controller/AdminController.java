package me.cloverclub.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.service.AdminService;
import me.cloverclub.service.CategoryService;
import me.cloverclub.service.MemberService;
import me.cloverclub.util.UploadFileUtil;
import me.cloverclub.vo.AdminorderVO;
import me.cloverclub.vo.CategoryVO;
import me.cloverclub.vo.GoodsVO;
import me.cloverclub.vo.MemberVO;
import me.cloverclub.vo.OrderListVO;
import me.cloverclub.vo.PickingVO;
import me.cloverclub.vo.ProcessVO;
import me.cloverclub.vo.ShopVO;
import net.sf.json.JSONArray;

@Controller
@Log4j
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	private AdminService a_service;
	private CategoryService c_service;
	private MemberService m_service;
	
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
		
		List<ShopVO> list = a_service.goodsList();
		model.addAttribute("list", list);
		
		return "/admin/goods/list";
	}
	
	// get view goods
	@GetMapping("/goods/view")
	public String getGoodsView(@RequestParam("n") String gdsCode, Model model) throws Exception {
		log.info("AdminController: getGoodsView()");
		
		ShopVO vo = a_service.goodsView(gdsCode);
		model.addAttribute("goods", vo);
		
		return "/admin/goods/view";
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
		log.info("AdminController: postGoodsAdd()");
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtil.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			fileName = UploadFileUtil.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		}
		
		else {
			fileName = File.separator + "images" + File.separator + "none.gif";
			
			vo.setGdsImg(fileName);
			vo.setGdsThumbImg(fileName);
		}
		
		a_service.goodsAdd(vo);
		
		return "redirect:/admin/goods/add";
	}
	
	// get goods modify
	@GetMapping("/goods/modify")
	public String getGoodsModify(@RequestParam("n") String gdsCode, Model model) throws Exception {
		log.info("AdminController: getGoodsModify()");
		
		ShopVO vo = a_service.goodsView(gdsCode);
		model.addAttribute("goods", vo);
		
		List<CategoryVO> category = null;
		category = c_service.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		
		return "/admin/goods/modify";
	}
	
	// post goods modify
	@PostMapping("/goods/modify")
	public String postGoodsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		log.info("AdminController: postGoodsModify()");
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			new File(uploadPath + req.getParameter("gdsImg")).delete();
			new File(uploadPath + req.getParameter("gdsThumbImg")).delete();
			
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtil.calcPath(imgUploadPath);
			String fileName = UploadFileUtil.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		}
		
		else {
			vo.setGdsImg(req.getParameter("gdsImg"));
			vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		}
		
		a_service.goodsModify(vo);
		
		return "redirect:/admin/index";
	}
	
	// post goods delete
	@PostMapping("/goods/delete")
	public String postGoodsDelete(@RequestParam("n") String gdsCode) throws Exception {
		log.info("AdminController: postGoodsDelete()");
		
		a_service.goodsDelete(gdsCode);
		
		return "redirect:/admin/index";
	}
	
	@PostMapping("/goods/ckUpload")
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		log.info("AdminController: postCKEditorImgUpload()");
		
		UUID uuid = UUID.randomUUID();
		
		OutputStream os = null;
		PrintWriter pw = null;
		
		req.setCharacterEncoding("UTF-8");
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		
		try {
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uuid + "_" + fileName;
			
			os = new FileOutputStream(new File(ckUploadPath));
			os.write(bytes);
			os.flush();
			
			pw = res.getWriter();
			String fileUrl = "/ckUpload/" + uuid + "_" + fileName;
			
			JsonObject json = new JsonObject();
			json.addProperty("uploaded", 1);
			json.addProperty("filename", fileName);
			json.addProperty("url", fileUrl);
			
			pw.println(json);
			pw.flush();
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(os != null) os.close();
				if(pw != null) pw.close();
			}
			
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return;
	}
	
	// get member list
	@GetMapping("/member/list")
	public String getMemberList(Model model) throws Exception {
		log.info("AdminController: getMemberList()");
		
		List<MemberVO> list = m_service.list();
		model.addAttribute("list", list);
		
		return "/admin/member/list";
	}
	
	//get order list
    @GetMapping(value = "/goods/order")
    public String getOrderlist(Model model) throws Exception {
       log.info("AdminController: getOrderList()");  
       
          List<AdminorderVO> orderView  = a_service.orderView();
          model.addAttribute("list", orderView);
          
          return "/admin/goods/order";
    }
    
  //get picking list
    @GetMapping(value = "/goods/picking")
    public String getPickinglist(Model model) throws Exception {
       log.info("AdminController: getPickingList()");  
       
          List<PickingVO> pickingView  = a_service.pickingView();
          model.addAttribute("list", pickingView);
          
          return "/admin/goods/picking";
    }
    
    //complete picking
    @RequestMapping(value = "/goods/pickingUpdate", method = RequestMethod.POST)
    public String pickingUpdate(ProcessVO vo) throws Exception {
    	a_service.pickingUpdate(vo);

		return "redirect:/admin/goods/picking";
	}
}