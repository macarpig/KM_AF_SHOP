package me.cloverclub.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.cloverclub.vo.NoticeVO;
import me.cloverclub.mapper.BoardMapper;
import me.cloverclub.vo.FaqVO;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {
	private BoardMapper mapper;
	
	//notice list
	@Override
	public List<NoticeVO> getNoticeList() throws Exception {
		log.info("NoticeList()");
		
		return mapper.getNoticeList();
	}
	
	//notice insert
	@Override
	public void insertNotice(NoticeVO notivo) throws Exception {
		log.info("NoticeInsert()");
		
		mapper.insertNotice(notivo);
	}
	
	//notice content
	@Override
	@Transactional
	public NoticeVO getNoticeContent(int noticeId) throws Exception {
		log.info("NoticeGetContent()");
		
		mapper.updateViewCnt(noticeId);
		return mapper.getNoticeContent(noticeId);
	}
	
	//notice update
	public void updateNotice(NoticeVO notivo) throws Exception {
		log.info("NoticeUpdate()");
		
		mapper.updateNotice(notivo);
	}
	
	//notice delete
	public void deleteNotice(int noticeId) throws Exception {
		log.info("NoticeDelete()");
		
		mapper.deleteNotice(noticeId);
	}
	
	//faq list
	@Override
	public List<FaqVO> getFaqList() throws Exception {
		log.info("FaqList()");
		
		return mapper.getFaqList();
	}
	
	//faq insert
	public void insertFaq(FaqVO faqvo) throws Exception {
		log.info("FaqInsert()");
		
		mapper.insertFaq(faqvo);
	}
	
	//faq content
	public FaqVO getFaqContent(int faqId) throws Exception {
		log.info("FaqContent()");
		
		return mapper.getFaqContent(faqId);
	}
	
	//faq update
	public void updateFaq(FaqVO faqvo) throws Exception {
		log.info("FaqUpdate()");
		
		mapper.updateFaq(faqvo);
	}
	
	//faq delete
	public void deleteFaq(int faqId) throws Exception {
		log.info("faqDelete()");
		
		mapper.deleteFaq(faqId);
	}
}
