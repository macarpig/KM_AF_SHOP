package me.cloverclub.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AdminorderVO {

	private String orderId;
	private String userId;
	private String orderRecvr;
	private String orderZipCode;
	private String orderAddr1;
	private String orderAddr2;
	private String orderTel1;
	private String orderTel2;
	private String orderTel3;
	private Date orderDate;
	private String gdsCode;
	private int cartStock;
	private int process;
	
}
