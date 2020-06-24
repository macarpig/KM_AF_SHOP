<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="./includes/header.jsp" %>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<% String gCode = request.getParameter("n");
String cStock = request.getParameter("s"); %>

   <div class="container">
      <div class="row">
         <div class="col-md-12 text-center">
            <div class="text-homeimage">
               <div class="maintext-image" data-scrollreveal="enter top over 1.5s after 0.1s">
                   Increase Digital Sales
               </div>
               <div class="subtext-image" data-scrollreveal="enter bottom over 1.7s after 0.3s">
                   Boost revenue with Scorilo
               </div>
            </div>
         </div>
      </div>
   </div>
</div>
</header>

<!-- CONTENT =============================-->
<section class="item content">
<div class="container toparea">
   <div class="underlined-title">
      <div class="editContent">
         <h1 class="text-center latestitems">MAKE PAYMENT</h1>
      </div>
      <div class="wow-hr type_short">
         <span class="wow-hr-h">
         <i class="fa fa-star"></i>
         <i class="fa fa-star"></i>
         <i class="fa fa-star"></i>
         </span>
      </div>
   </div>
   <div id="edd_checkout_wrap" class="col-md-8 col-md-offset-2">
      <form id="edd_checkout_cart_form" method="post">
         <div id="edd_checkout_cart_wrap">
            <table id="edd_checkout_cart" class="ajaxed">
            <thead>
            <tr class="edd_cart_header_row">
               <th>
                   <input type="checkbox" name="allCheck"/><label for="allCheck">모두 선택</label>
               	   <script>
               	   $("#allCheck").click(function() {
					var chk = $("#allCheck").prop("checked");
					if(chk){
						$(".chBox").prop("checked", true);
					}else{
						$(".chBox").prop("checked", false);
					}
				});
               	   </script>
               </th>
               <th class="edd_cart_item_name">
                   Item Name
               </th>
               <th class="edd_cart_item_price">
                   Item Price
               </th>
               <th class="edd_cart_actions">
                   <a class="selectDelete_btn">선택 삭제</a>
                   <script>
                   	$(".selectDelete_btn").click(function() {
						var confirm_val = confirm("정말 삭제하시겠습니까?");
						
						if(confirm_val){
							var checkArr = new Array();
							
							$("input[class='chBox']:checked").each(function() {
								checkArr.push($(this).attr("data-gdsCode"));
							});
							
							$.ajax({
								url : "/deleteCart",
								type : "post",
								data : { chbox : checkArr },
								success : function (result) {
									if(result == 1){

										location.href = "/checkout";
									}else{
										alert("삭제 실패");
									}
								}
							})
						}
					})
                   </script>
               </th>
            </tr>
            </thead>
            <tbody>            
            <c:set var="sum" value="0"/>
            <c:forEach items="${showCart}" var="showCart">
            <tr class="edd_cart_item" id="edd_cart_item_0_25" data-download-id="25">
               <td>
               		<input type="checkbox" name="chBox" class="chBox" data-gdsCode="${showCart.gdsCode}"/>
               		<script>
               			$(".chBox").click(function() {
							$("#allCheck").prop("checked", false);
						});
               		</script>
               </td>
               <td class="edd_cart_item_name">
                  <div class="edd_cart_item_image">
                     <img width="25" height="25" src="${showCart.gdsImg}" alt="">
                  </div>
                  <span class="edd_checkout_cart_item_title">${showCart.gdsName} · ${showCart.cartStock}개</span>
               </td>
               <td class="edd_cart_item_price">
               <c:set var="price" value="${showCart.gdsPrice * showCart.cartStock}"/>
                      (￦${showCart.gdsPrice} * ${showCart.cartStock}개)<br> = ￦${price}
               </td>
               <td class="edd_cart_actions">
                  <a class="remove_${showCart.gdsCode}_btn" data-gdsCode="${showCart.gdsCode}" data-cartStock="${showCart.cartStock}">-</a>&nbsp;
                  <script>
                  	$(".remove_${showCart.gdsCode}_btn").click(function() {
						if($(this).attr("data-cartStock") == 1){
							var confirm_val = confirm("정말 이 상품을 삭제하시겠습니까?");
							
							if(confirm_val){
								var checkArr = new Array();
								checkArr.push($(this).attr("data-gdsCode"));
								
								$.ajax({
									url : "/deleteCart",
									type : "post",
									data : { chbox : checkArr},
									success : function (result) {
										if(result == 1){
											location.href = "/checkout";
										}else {
											alert("삭제 실패");
										}
									}
								});
							}
						}else{
							var confirm_val = confirm("하나 더 제거하시겠습니까?");
							
							if(confirm_val){
								var checkArr = new Array();
								checkArr.push($(this).attr("data-gdsCode"));
								
								$.ajax({
									url : "/removeCart",
									type : "post",
									data : { chbox : checkArr},
									success : function (result) {
										if(result == 1){
											location.href = "/checkout";
										}else {
											alert("하나 제거 실패");
										}
									}
								});
							}
						}
					});
                  </script>
                  <a class="add_${showCart.gdsCode}_btn" data-gdsCode="${showCart.gdsCode}">+</a>&nbsp;
                  <script>
                  	$(".add_${showCart.gdsCode}_btn").click(function() {
						var confirm_val = confirm("하나 더 추가하시겠습니까?");
						
						if(confirm_val){
							var checkArr = new Array();
							checkArr.push($(this).attr("data-gdsCode"));
							
							$.ajax({
								url : "/addCart",
								type : "post",
								data : { chbox : checkArr},
								success : function (result) {
									if(result == 1){
										location.href = "/checkout";
									}else {
										alert("하나 추가 실패");
									}
								}
							});
						}
					});
                  </script>
                  <a class="delete_${showCart.gdsCode}_btn" data-gdsCode="${showCart.gdsCode}">삭제</a>
                  <script>
                  	$(".delete_${showCart.gdsCode}_btn").click(function() {
						var confirm_val = confirm("정말 이 상품을 삭제하시겠습니까?");
						
						if(confirm_val){
							var checkArr = new Array();
							checkArr.push($(this).attr("data-gdsCode"));
							
							$.ajax({
								url : "/deleteCart",
								type : "post",
								data : { chbox : checkArr},
								success : function (result) {
									if(result == 1){
										location.href = "/checkout";
									}else {
										alert("삭제 실패");
									}
								}
							});
						}
					});
                  </script>
               </td>
            </tr>
            <c:set var="sum" value="${sum + price}"/> 
            </c:forEach>
            <% if(gCode != null&cStock!=null){%>
               <tr class="edd_cart_item" id="edd_cart_item_0_25" data-download-id="25">
               <td class="edd_cart_item_name">
                  <div class="edd_cart_item_image">
                     <img width="25" height="25" src="${product.gdsImg}" alt="">
                  </div>
                  <span class="edd_checkout_cart_item_title">${product.gdsName} · <%=cStock %>개</span>
               </td>
               <td class="edd_cart_item_price">
               <c:set var="price" value="${product.gdsPrice * param.s}"/>
                      (￦${showCart.gdsPrice} * ${param.s}개)<br> = ￦${price}
               </td>
               <td class="edd_cart_actions">
                  <a class="remove_btn" data-gdsCode="${showCart.gdsCode}" data-cartStock="${showCart.cartStock}">-</a>&nbsp;
                  <script>
                  	$(".remove_btn").click(function() {
                  		if($(this).attr("data-cartStock") == 1){
							var confirm_val = confirm("정말 이 상품을 삭제하시겠습니까? 삭제하시면 해당 상품화면으로 돌아갑니다.");
							
							if(confirm_val){
								location.href ="/product?n="+ $(this).attr("data-gdsCode");
							}
                  		}else{
                  			var confirm_val = confirm("하나 더 제거하시겠습니까?");
    						
    						if(confirm_val){
    							location.href ="/checkout?n="+ $(this).attr("data-gdsCode")+"&s="+($(this).attr("data-cartStock")-1);
    						}
                  		}
                  		
					});
                  </script>
                  <a class="add_btn" data-gdsCode="${showCart.gdsCode}" data-cartStock="${showCart.cartStock}">+</a>&nbsp;
                  <script>
                  	$(".add_btn").click(function() {
						var confirm_val = confirm("하나 더 추가하시겠습니까?");
						
						if(confirm_val){
							location.href ="/checkout?n="+ $(this).attr("data-gdsCode")+"&s="+($(this).attr("data-cartStock")+1);
						}
					});
                  </script>
                  <a class="delete_btn" data-gdsCode="${showCart.gdsCode}">삭제</a>
                   <script>
                  	$(".delete_btn").click(function() {
						var confirm_val = confirm("정말 이 상품을 삭제하시겠습니까? 삭제하시면 해당 상품화면으로 돌아갑니다.");
						
						if(confirm_val){
							location.href ="/product?n="+ $(this).attr("data-gdsCode");
						}
					});
                  </script>
               </td>
            </tr>
            <%}
            %>
            </tbody>
            <tfoot>
            <tr class="edd_cart_footer_row edd_cart_discount_row" style="display:none;">
               <th colspan="5" class="edd_cart_discount">
               </th>
            </tr>
            <tr class="edd_cart_footer_row">
               <th colspan="5" class="edd_cart_total">
                   Total: <span class="edd_cart_amount" data-subtotal="11.99" data-total="11.99">${sum}</span>
               </th>
            </tr>
            </tfoot>
            </table>
         </div>
      </form>
      <div id="edd_checkout_form_wrap" class="edd_clearfix">
         <form id="edd_purchase_form" class="edd_form" action="order" method="POST">
            <fieldset id="edd_purchase_submit">
               <p id="edd_final_total_wrap">
                  <strong>Purchase Total:</strong>
                  <span class="edd_cart_amount" data-subtotal="11.99" data-total="11.99">${sum}</span>
               </p>
               <% if(gCode != null&cStock!=null){%>
               <input type="hidden" name="gCode" value="<%=gCode%>">
               <input type="hidden" name="cStock" value="<%=cStock%>">
               <%} %>
               <input type="hidden" name="edd_action" value="purchase">
               <input type="hidden" name="edd-gateway" value="manual">
               <input type="submit" class="edd-submit button" id="edd-purchase-button" name="edd-purchase" value="Purchase">
            </fieldset>
         </form>
      </div>
   </div>
</div>
</section>

<!-- CALL TO ACTION =============================-->
<section class="content-block" style="background-color:#00bba7;">
<div class="container text-center">
   <div class="row">
      <div class="col-sm-10 col-sm-offset-1">
         <div class="item" data-scrollreveal="enter top over 0.4s after 0.1s">
            <h1 class="callactiontitle"> Promote Items Area Give Discount to Buyers <span class="callactionbutton"><i class="fa fa-gift"></i> WOW24TH</span>
            </h1>
         </div>
      </div>
   </div>
</div>
</section>

<%@include file="./includes/footer.jsp" %>