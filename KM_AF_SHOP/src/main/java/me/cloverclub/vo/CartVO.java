package me.cloverclub.vo;

import lombok.Data;

@Data
public class CartVO {
	private int cartId;
	private String userId;
	private int gdsCode;
	private int cartStock;
}
