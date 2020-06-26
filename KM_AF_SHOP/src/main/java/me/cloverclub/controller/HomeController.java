
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
import me.cloverclub.vo.OrderListVO;
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
      public String getCartCheck(@RequestParam("n") int gdsCode, @RequestParam("s") int cartStock, Model model, HttpServletRequest request, HttpServletResponse response, CartVO cart) throws Exception {
    	  HttpSession session = request.getSession();
         MemberVO userId = (MemberVO)session.getAttribute("member");
         if(userId == null) {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인을 해주세요.'); history.go(-1);</script>");
            out.flush();
         }else {
             log.info("getCartCheck() userId : "+userId.getUserId()+ " gdsCode : "+gdsCode+" cartStock :" + cartStock);
             cart.setUserId(userId.getUserId());
             cart.setGdsCode(gdsCode);
             cart.setCartStock(cartStock);
            s_service.addCart(cart);
            
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>var con_test = confirm(\"장바구니에 담았습니다. 장바구니로 이동하시겠습니까?\"); " + 
                  "if(con_test == false){" + 
                  "  history.go(-1);" + 
                  "}</script>");
            out.flush();
            List<CartVO> carts = s_service.showCart(userId.getUserId());
            model.addAttribute("showCart", carts);
         }
      return "checkout";
      }
      
      @GetMapping("/purchaseCheck")
      public String getPurchaseCheck(@RequestParam("n") String gdsCode, @RequestParam("s") int cartStock, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	  log.info("getPurchaseCheck() gdsCode : "+gdsCode+" cartStock :" + cartStock);
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
      
      @PostMapping("/plusCart")
      public int postPlusCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr, CartVO cart) throws Exception {
         MemberVO member = (MemberVO)session.getAttribute("member");
         String userId = member.getUserId();
         
         int result = 0;
         int gdsCode = 0;
         
         if(member != null) {
            cart.setUserId(userId);
            
            for(String i : chArr) {
               gdsCode = Integer.parseInt(i);
               cart.setGdsCode(gdsCode);
               s_service.plusCart(cart);
            }
            result = 1;
         }
         return result;
      }
      
      @PostMapping("/removeCart")
      public int postRemoveCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr, CartVO cart) throws Exception {
         MemberVO member = (MemberVO)session.getAttribute("member");
         String userId = member.getUserId();
         
         int result = 0;
         int gdsCode = 0;
         
         if(member != null) {
            cart.setUserId(userId);
            
            for(String i : chArr) {
               gdsCode = Integer.parseInt(i);
               cart.setGdsCode(gdsCode);
               s_service.removeCart(cart);
            }
            result = 1;
         }
         return result;
      }
      
      @GetMapping("/cart")
      public String getCart(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
         HttpSession session = request.getSession();
          MemberVO userId = (MemberVO)session.getAttribute("member");
          if(userId == null) {
             response.setContentType("text/html; charset=UTF-8");
             PrintWriter out = response.getWriter();
             out.println("<script>alert('로그인을 해주세요.'); history.go(-1);</script>");
             out.flush();
          }else {
             List<CartVO> cart = s_service.showCart(userId.getUserId());
             model.addAttribute("showCart", cart);
          }
       return "checkout";
      }
      
      @PostMapping("/order")
      public void postOrder(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	  HttpSession session = request.getSession();
          MemberVO userId = (MemberVO)session.getAttribute("member");
          String gCode = request.getParameter("gCode");
          if(userId == null) {
              response.setContentType("text/html; charset=UTF-8");
              PrintWriter out = response.getWriter();
              out.println("<script>alert('주문 접속에 실패했습니다. 로그인을 다시 해주세요.'); history.go(-1);</script>");
              out.flush();
           }else {
          if(gCode != null) {
        	  String cStock = request.getParameter("cStock");
        	  model.addAttribute("gCode", gCode);
        	  model.addAttribute("cStock", cStock);
          }else {
        	  List<CartVO> cart = s_service.showCart(userId.getUserId());
              model.addAttribute("showCart", cart);
          }
           }
      }
     
      //주문완료체크
      @PostMapping("/ordercheck")
      public void postOrdercheck(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	  HttpSession session = request.getSession();
          MemberVO userId = (MemberVO)session.getAttribute("member");
          String gCode = request.getParameter("gCode");
          if(userId == null) {
              response.setContentType("text/html; charset=UTF-8");
              PrintWriter out = response.getWriter();
              out.println("<script>alert('죄송합니다. 주문 접속에 실패했습니다. 로그인을 다시 해주세요.'); history.go(-1);</script>");
              out.flush();
           }else {
        	   if(gCode != null) {
        	  String cStock = request.getParameter("cStock");

          	}else {
        	  List<CartVO> cart = s_service.showCart(userId.getUserId());
              model.addAttribute("showCart", cart);
          	}
          }
      }
      
    //주문내역 출력
  	@GetMapping(value = "/orderList")
  	public void getOrderlist(HttpSession session,
  			Model model,@RequestParam(value="c", required=false) String userId, OrderListVO order) throws Exception {
  		log.info("getOrderList()");
  		MemberVO member = (MemberVO)session.getAttribute("member");
  		order.setUserId(userId);	
  		if(member==null) {
  			System.out.println("로그인 하고오세요.");
  		} else {	
  			System.out.println(userId);
  			List<OrderListVO> orderView  = s_service.orderView(order);
  			model.addAttribute("orderView", orderView);
  		}
  	}
      	
      
}

