package me.cloverclub.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class PayVO {
	private String orderId;
	private String payCorp;
	private String payCode;
}
