package me.cloverclub.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import me.cloverclub.service.CategoryService;
import me.cloverclub.service.ShopService;
import me.cloverclub.vo.CartVO;
import me.cloverclub.vo.CategoryVO;
import me.cloverclub.vo.MemberVO;
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
      public void getProduct(@RequestParam("n") String gdsCode, Model model) throws Exception {
         ShopVO product = s_service.product(gdsCode);
         model.addAttribute("product", product);
      }
      
      @GetMapping("/cartCheck")
      public String getCartCheck(@RequestParam("n") int gdsCode, @RequestParam("s") int cartStock, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
         HttpSession session = request.getSession();
         MemberVO userId = (MemberVO)session.getAttribute("member");
         if(userId == null) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인을 해주세요.'); history.go(-1);</script>");
            out.flush();
         }else {
            s_service.addCart(userId.getUserId(), gdsCode, cartStock);
            
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>var con_test = confirm(\"장바구니에 담았습니다. 장바구니로 이동하시겠습니까?\"); " + 
                  "if(con_test == false){" + 
                  "  history.go(-1);" + 
                  "}</script>");
            out.flush();
            List<CartVO> cart = s_service.showCart(userId.getUserId());
            model.addAttribute("showCart", cart);
         }
      return "checkout";
      }
      
      @GetMapping("/purchaseCheck")
      public String getPurchaseCheck(@RequestParam("n") String gdsCode, @RequestParam("s") int cartStock, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
         HttpSession session = request.getSession();
         MemberVO userId = (MemberVO)session.getAttribute("member");
         if(userId == null) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인을 해주세요.'); history.go(-1);</script>");
            out.flush();
         }else {
            ShopVO product = s_service.product(gdsCode);
             model.addAttribute("product", product);
         }
      return "checkout?n="+gdsCode+"&s="+cartStock;
      }
      
      @PostMapping("/deleteCart")
      public int postDeleteCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr, CartVO cart) throws Exception {
    	  MemberVO member = (MemberVO)session.getAttribute("member");
    	  String userId = member.getUserId();
    	  
    	  int result = 0;
    	  int gdsCode = 0;
    	  
    	  if(member != null) {
    		  cart.setUserId(userId);
    		  
    		  for(String i : chArr) {
    			  gdsCode = Integer.parseInt(i);
    			  cart.setGdsCode(gdsCode);
    			  s_service.deleteCart(cart);
    		  }
    		  result = 1;
    	  }
    	  return result;
      }
      
}