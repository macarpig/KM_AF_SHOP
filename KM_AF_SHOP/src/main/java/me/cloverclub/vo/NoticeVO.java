package me.cloverclub.vo;

import lombok.Data;

@Data
public class NoticeVO {
	private int noticeId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	private int noticeView;
}
