package me.cloverclub.mapper;

import java.util.List;

import me.cloverclub.vo.FaqVO;
import me.cloverclub.vo.NoticeVO;

public interface BoardMapper {
	//Notice list
	public List<NoticeVO> getNoticeList() throws Exception;
	
	//Notice insert
	public void insertNotice(NoticeVO notivo) throws Exception;
	
	//Notice Content
	public NoticeVO getNoticeContent(int noticeId) throws Exception;
	
	//Notice Update
	public void updateNotice(NoticeVO notivo) throws Exception;
	
	//Notice Delete
	public void deleteNotice(int noticeId) throws Exception;
	
	//Faq list
	public List<FaqVO> getFaqList() throws Exception;
	
	//Faq insert
	public void insertFaq(FaqVO faqvo) throws Exception;
	
	//Faq Content
	public FaqVO getFaqContent(int faqId) throws Exception;
	
	//Faq Update
	public void updateFaq(FaqVO faqvo) throws Exception;
	
	//Faq delete
	public void deleteFaq(int faqId) throws Exception;
	
	//Notice View update
	public int updateViewCnt(int noticeId) throws Exception;
}
