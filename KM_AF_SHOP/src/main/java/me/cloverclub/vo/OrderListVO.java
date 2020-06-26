package me.cloverclub.vo;

import java.util.Date;

import lombok.Data;

@Data
public class OrderListVO {
	private String orderId;
	private String userId;
	private Date orderDate;
	private String gdsCode;
	private int process;
	private int gdsSum;
	private String gdsName;
	private int gdsPrice;
	private String gdsImg;
	
}
