package me.cloverclub.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String userId;
	private String userPw;
	private String userName;
	private String userEmail;
	private String userTel;
	private String userZipcode;
	private String userAddr1;
	private String userAddr2;
	private int userAuth;
}
