package me.cloverclub.vo;

import lombok.Data;

@Data
public class PickingVO {

	private String orderId;
	private String gdsCode;
	private int cartStock;
	private int process;
	private String gdsThumbImg;
}
