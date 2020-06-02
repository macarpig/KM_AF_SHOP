package me.cloverclub.vo;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsVO {
	private String gdsCode;
	private String gdsName;
	private String cateCode;
	private int gdsPrice;
	private String gdsDesc;
	private String gdsImg;
	private Date gdsDate;
	private int gdsView;
}
