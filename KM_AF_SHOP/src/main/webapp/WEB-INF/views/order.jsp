<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="./includes/header.jsp" %>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<style>
.box-radio-input input[type="radio"]{
    display:none;
}

.box-radio-input input[type="radio"] + span{
    display:inline-block;
    background:none;
    border:1px solid #dfdfdf;    
    padding:0px 10px;
    text-align:center;
    height:35px;
    line-height:33px;
    font-weight:500;
    cursor:pointer;
}

.box-radio-input input[type="radio"]:checked + span{
    border:1px solid #23a3a7;
    background:#23a3a7;
    color:#fff;
}
</style>
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
      <div id="edd_checkout_form_wrap" class="edd_clearfix">
         <form id="edd_purchase_form" class="edd_form" action="#" method="POST">
            <fieldset id="edd_checkout_user_info">
               <legend>Personal Info</legend>
               <p id="edd-zip-code-wrap">
                  <label class="edd-label" for="edd-zip-code">
                  	우편번호 <span class="edd-required-indicator">*</span></label>
                  <input class="edd-input required" type="number" name="edd_zip-code" placeholder="우편번호" id="edd-zip-code" value="" required>
                  <input style="border:none;" type="button" value="우편번호 찾기">
               </p>
               <p id="edd-address-wrap">
                  <label class="edd-label" for="edd-address">
                  	주소 <span class="edd-required-indicator">*</span>
                  </label>
                  <input class="edd-input required" type="text" name="edd_address" placeholder="지역명(동/리)+번지 또는 도로명+건물번호를 입력하세요" id="edd-address" value="" required>
               </p>
               <p id="edd-detail-address-wrap">
                  <label class="edd-label" for="edd-detail-address">
                  	상세주소 </label>
                  <input class="edd-input" type="text" name="edd_detail-address" id="edd-detail-address" placeholder="상세주소를 입력하세요(건물명, 동/호수 등)" value="">
               </p>
               <p id="edd-reciever-wrap">
                  <label class="edd-label" for="edd-reciever">
                  	수신자  <span class="edd-required-indicator">*</span>
                  	</label>
                  <input class="edd-input" type="text" name="edd_reciever" id="edd-reciever" placeholder="수신자를 입력해주세요" value="" required>
               </p>
               <p id="edd-phone-wrap">
                  <label class="edd-label" for="edd-phone">
                  	전화번호 <span class="edd-required-indicator">*</span>
                  	 </label>
                  	<select class="edd-input" name="edd_phone1" id="edd-phone1">
                  	<option>010</option>
                  	<option>011</option>
                  	<option>020</option>
                  	<option>030</option>
                  	<option>040</option>
                  	<option>050</option>
                  	<option>060</option>
                  	<option>070</option>
                  	<option>080</option>
                  	<option>090</option>
                  	</select>
                  -<input class="edd-input" type="number" size="4" maxlength="4" name="edd_phone2" id="edd-phone2" value="" required>-<input class="edd-input" type="number" size="4" maxlength="4" name="edd_phone3" id="edd-phone3" value="" required>
               </p>
               <p id="edd-phone-wrap">
                  <label class="edd-label" for="edd-phone">
                  	요청사항 </label>
					<textarea class="edd-input" rows="3" name="edd_require" id="edd-require" placeholder="요청사항을 입력하세요"></textarea>
               </p>
            </fieldset>
            <c:set var="sum" value="0"/>
            <fieldset id="edd_checkout_list">
            	<p id="edd_list">
            		<c:forEach items="${showCart}" var="showCart">
            		${showCart.gdsName} · ${showCart.cartStock}개 
            		<c:set var="price" value="${showCart.gdsPrice * showCart.cartStock}"/>
            		(￦${showCart.gdsPrice} * ${showCart.cartStock}개)<br> = ￦${price}<br>
            		</c:forEach>
            		<c:set var="sum" value="${sum + price}"/> 
            	</p>
            </fieldset>
            <fieldset id="edd_purchase_submit">
               <p id="edd_final_total_wrap">
                  <strong>Purchase Total:</strong>
                  <span class="edd_cart_amount" data-subtotal="11.99" data-total="11.99">${sum}</span>
               </p>
               <p id="edd_payment_method_wrap">
                  <strong>결제수단:</strong>
                  <label class="box-radio-input" for="payCard"><input type="radio" style="display:none;" name="payment_method" id="payCard" value="신용카드"><span>신용카드</span></label>
                  <label class="box-radio-input" for="payPhone"><input type="radio" style="display:none;" name="payment_method" id="payPhone" value="휴대전화"><span>휴대전화</span></label>
                  <label class="box-radio-input" for="payKakao"><input type="radio" style="display:none;" name="payment_method" id="payKakao" value="카카오페이"><span>카카오페이</span></label>
                  <label class="box-radio-input" for="payNaver"><input type="radio" style="display:none;" name="payment_method" id="payNaver" value="네이버페이"><span>네이버페이</span></label>
                  <label class="box-radio-input" for="payBank"><input type="radio" style="display:none;" name="payment_method" id="payBank" value="실시간계좌이체"><span>실시간계좌이체</span></label>
               </p>
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