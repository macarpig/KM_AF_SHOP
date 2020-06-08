package me.cloverclub.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ShopVO {
	private String gdsCode;
	private String gdsName;
	private String cateCode;
	private String cateCodeRef;
	private int gdsPrice;
	private String gdsDesc;
	private String gdsImg;
	private String gdsThumbImg;
	private Date gdsDate;
	private int gdsView;
}
