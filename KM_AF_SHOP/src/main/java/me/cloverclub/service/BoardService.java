package me.cloverclub.service;

import java.util.List;

import me.cloverclub.vo.NoticeVO;
import me.cloverclub.vo.FaqVO;

public interface BoardService {
	public List<NoticeVO> getNoticeList() throws Exception;
	
	public void insertNotice(NoticeVO notivo) throws Exception;
	
	public NoticeVO getNoticeContent(int noticeId) throws Exception;
	
	public void updateNotice(NoticeVO notivo) throws Exception;
	
	public void deleteNotice(int noticeId) throws Exception;
	
	public List<FaqVO> getFaqList() throws Exception;
	
	public void insertFaq(FaqVO faqvo) throws Exception;
	
	public FaqVO getFaqContent(int faqId) throws Exception;
	
	public void updateFaq(FaqVO faqvo) throws Exception;
	
	public void deleteFaq(int faqId) throws Exception;
	
}
