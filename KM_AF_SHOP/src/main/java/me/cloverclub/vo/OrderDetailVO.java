package me.cloverclub.vo;

import lombok.Data;

@Data
public class OrderDetailVO {
	private String orderDetailed;
	private String orderId;
	private int gdsCode;
	private int cartStock;
	private String gdsStatus;
	private int gdsSum;
}
