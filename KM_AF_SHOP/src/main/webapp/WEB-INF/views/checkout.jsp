<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="./includes/header.jsp" %>

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
					<th class="edd_cart_item_name">
						 Item Name
					</th>
					<th class="edd_cart_item_price">
						 Item Price
					</th>
					<th class="edd_cart_actions">
						 Actions
					</th>
				</tr>
				</thead>
				<tbody>
				<tr class="edd_cart_item" id="edd_cart_item_0_25" data-download-id="25">
					<td class="edd_cart_item_name">
						<div class="edd_cart_item_image">
							<img width="25" height="25" src="images/scorilo2-70x70.jpg" alt="">
						</div>
						<span class="edd_checkout_cart_item_title">Audio Item - Single License</span>
					</td>
					<td class="edd_cart_item_price">
						 $11.99
					</td>
					<td class="edd_cart_actions">
						<a class="edd_cart_remove_item_btn" href="#">Remove</a>
					</td>
				</tr>
				</tbody>
				<tfoot>
				<tr class="edd_cart_footer_row">
					<th colspan="5">
						<a class="edd-cart-saving-button edd-submit button " id="edd-save-cart-button" href="#">Save Cart</a>
					</th>
				</tr>
				<tr class="edd_cart_footer_row edd_cart_discount_row" style="display:none;">
					<th colspan="5" class="edd_cart_discount">
					</th>
				</tr>
				<tr class="edd_cart_footer_row">
					<th colspan="5" class="edd_cart_total">
						 Total: <span class="edd_cart_amount" data-subtotal="11.99" data-total="11.99">$11.99</span>
					</th>
				</tr>
				</tfoot>
				</table>
			</div>
		</form>
		<div id="edd_checkout_form_wrap" class="edd_clearfix">
			<form id="edd_purchase_form" class="edd_form" action="#" method="POST">
				<fieldset id="edd_checkout_user_info">
					<legend>Personal Info</legend>
					<p id="edd-email-wrap">
						<label class="edd-label" for="edd-email">
						Email Address <span class="edd-required-indicator">*</span></label>
						<input class="edd-input required" type="email" name="edd_email" placeholder="Email address" id="edd-email" value="">
					</p>
					<p id="edd-first-name-wrap">
						<label class="edd-label" for="edd-first">
						First Name <span class="edd-required-indicator">*</span>
						</label>
						<input class="edd-input required" type="text" name="edd_first" placeholder="First name" id="edd-first" value="" required="">
					</p>
					<p id="edd-last-name-wrap">
						<label class="edd-label" for="edd-last">
						Last Name </label>
						<input class="edd-input" type="text" name="edd_last" id="edd-last" placeholder="Last name" value="">
					</p>
				</fieldset>
				<fieldset id="edd_purchase_submit">
					<p id="edd_final_total_wrap">
						<strong>Purchase Total:</strong>
						<span class="edd_cart_amount" data-subtotal="11.99" data-total="11.99">$11.99</span>
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