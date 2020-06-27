<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="./includes/header.jsp" %>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
                  function execPostCode() {
                      new daum.Postcode({
                          oncomplete: function(data) {
                             // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
              
                             // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                             // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                             var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                             var extraRoadAddr = ''; // 도로명 조합형 주소 변수
              
                             // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                             // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                             if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                                 extraRoadAddr += data.bname;
                             }
                             // 건물명이 있고, 공동주택일 경우 추가한다.
                             if(data.buildingName !== '' && data.apartment === 'Y'){
                                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                             }
                             // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                             if(extraRoadAddr !== ''){
                                 extraRoadAddr = ' (' + extraRoadAddr + ')';
                             }
                             // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                             if(fullRoadAddr !== ''){
                                 fullRoadAddr += extraRoadAddr;
                             }
              
                             // 우편번호와 주소 정보를 해당 필드에 넣는다.
                             console.log(data.zonecode);
                             console.log(fullRoadAddr);
                             
                             
                             $("[name=zip-code]").val(data.zonecode);
                             $("[name=address]").val(fullRoadAddr);
                             
                             document.getElementByName('zip-code').value = data.zonecode; //5자리 새우편번호 사용
                             document.getElementByName('address').value = fullRoadAddr;
                             document.getElementByName('detail-address').value = data.jibunAddress;
                         }
                      }).open();
                  }
</script>
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
         <form id="edd_purchase_form" class="edd_form" action="ordercheck" method="POST">
            <fieldset id="edd_checkout_user_info">
               <legend>Personal Info</legend>
               <p id="edd-reciever-wrap">
                  <label class="edd-label" for="edd-reciever">
                     수신자  <span class="edd-required-indicator">*</span>
                     </label>
                  <input class="edd-input" type="text" name="reciever" id="reciever" placeholder="수신자를 입력해주세요" value="" required>
               </p>
               <p id="edd-zip-code-wrap">
                  <label class="edd-label" for="edd-zip-code">
                     우편번호 <span class="edd-required-indicator">*</span></label>
                  <input class="edd-input required" style="background-color:#EAEAEA;" type="number" name="zip-code" placeholder="우편번호" id="zip-code" value="" type="text" readonly="readonly" required>
                  <input style="border:none; background-color:#5D5D5D; color:white;" type="button" onclick="execPostCode();" value="우편번호 찾기">
               </p>
               <p id="edd-address-wrap">
                  <label class="edd-label" for="edd-address">
                     주소 <span class="edd-required-indicator">*</span>
                  </label>
                  <input class="edd-input required" style="background-color:#EAEAEA;" type="text" name="address" placeholder="지역명(동/리)+번지 또는 도로명+건물번호를 입력하세요" id="address" value=""type="text" readonly="readonly" required>
               </p>
               <p id="edd-detail-address-wrap">
                  <label class="edd-label" for="edd-detail-address">
                     상세주소 </label>
                  <input class="edd-input" type="text" name="detail-address" id="detail-address" placeholder="상세주소를 입력하세요(건물명, 동/호수 등)" value="">
               </p>
               <p id="edd-phone-wrap">
                  <label class="edd-label" for="phone">
                     전화번호 <span class="edd-required-indicator">*</span>
                      </label>
                     <select class="edd-input" name="phone1" id="phone1">
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
                  -<input class="edd-input" type="number" size="4" maxlength="4" name="phone2" id="phone2" value="" required>-<input class="edd-input" type="number" size="4" maxlength="4" name="phone3" id="phone3" value="" required>
               </p>
               <p id="edd-require-wrap">
                  <label class="edd-label" for="require">
                     요청사항 </label>
               <textarea class="edd-input" rows="3" name="require" id="require" placeholder="요청사항을 입력하세요"></textarea>
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
                  <label class="box-radio-input" for="payCard"><input type="radio" style="display:none;" name="payment_method" id="payCard" value="신용카드" required><span>신용카드</span></label>
                  <label class="box-radio-input" for="payPhone"><input type="radio" style="display:none;" name="payment_method" id="payPhone" value="휴대전화" required><span>휴대전화</span></label>
                  <label class="box-radio-input" for="payKakao"><input type="radio" style="display:none;" name="payment_method" id="payKakao" value="카카오페이" required><span>카카오페이</span></label>
                  <label class="box-radio-input" for="payNaver"><input type="radio" style="display:none;" name="payment_method" id="payNaver" value="네이버페이" required><span>네이버페이</span></label>
                  <label class="box-radio-input" for="payBank"><input type="radio" style="display:none;" name="payment_method" id="payBank" value="실시간계좌이체" required><span>실시간계좌이체</span></label>
               </p>
               <input type="hidden" name="gCode" value="${gCode}">
               <input type="hidden" name="cStock" value="${cStock}">
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