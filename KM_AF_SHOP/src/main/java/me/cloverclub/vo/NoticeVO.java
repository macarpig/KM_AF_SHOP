package me.cloverclub.vo;

import lombok.Data;

@Data
public class NoticeVO {
	private int noticeId;
	private String notiTitle;
	private String notiContent;
	private String notiDate;
	private int notiView;
}
