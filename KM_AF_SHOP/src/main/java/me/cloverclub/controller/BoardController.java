package me.cloverclub.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;
import me.cloverclub.service.BoardService;
import me.cloverclub.vo.FaqVO;
import me.cloverclub.vo.NoticeVO;

@Controller
@Log4j
public class BoardController {
	
	@Inject
	private BoardService boardservice;
	
	//���� ��� ���
	@RequestMapping(value = "/getNoticeList", method= RequestMethod.GET)
	public String getNoticeList(Model model) throws Exception {
		model.addAttribute("noticeList", boardservice.getNoticeList());
		
		log.info("noticeList()" + model);	
		return "notice";
			
	}
	
	//faq ��� ���
		@RequestMapping(value = "/getFaqList", method= RequestMethod.GET)
		public String getFaqList(Model model) throws Exception {

			model.addAttribute("faqList", boardservice.getFaqList());
			log.info("faqList()" + model);
			return "faq";	
		}
	
	//���� �� ȭ��
	@RequestMapping("/noticeForm")
	public String boardForm(@ModelAttribute("noticeVO") NoticeVO notivo, Model model) {
		return "noticeForm";
	}
	
	//faq �� ȭ��
		@RequestMapping("/faqForm")
		public String boardForm(@ModelAttribute("faqVO") FaqVO faqvo, Model model) {
			return "faqForm";
		}
	
	//���� �Խù� ����
	@RequestMapping(value = "/saveNotice", method = RequestMethod.POST)
	public String saveBoard(@ModelAttribute("noticeVO") NoticeVO notivo
			, @RequestParam("mode") String mode
			, @RequestParam("noticeId") int noticeId
			, RedirectAttributes rttr) throws Exception {
		if(mode.equals("edit")) {
			boardservice.updateNotice(notivo);
		} else {
			boardservice.insertNotice(notivo);
		}
		return "redirect:/getNoticeList";
	}
	
	//faq �Խù� ����
		@RequestMapping(value = "/saveFaq", method = RequestMethod.POST)
		public String saveFaq(@ModelAttribute("faqVO") FaqVO faqvo
				, @RequestParam("mode") String mode
				, @RequestParam("faqId") int faqId
				, RedirectAttributes rttr) throws Exception {
			if(mode.equals("edit")) {
				boardservice.updateFaq(faqvo);
			} else {
				boardservice.insertFaq(faqvo);
			}
			return "redirect:/getFaqList";
		}
	
	//���� �Խù� ����
	@RequestMapping(value = "/getNoticeContent", method = RequestMethod.GET)
	public String getBoardContent(Model model, @RequestParam("noticeid") int noticeid) throws Exception {
		model.addAttribute("noticeContent", boardservice.getNoticeContent(noticeid));
		return "noticeContent";
	}
	
	//faq �Խù� ����
		@RequestMapping(value = "/getFaqContent", method = RequestMethod.GET)
		public String getFaqContent(Model model, @RequestParam("faqId") int faqid) throws Exception {
			model.addAttribute("faqContent", boardservice.getFaqContent(faqid));
			return "faqContent";
		}

	//���� �۾���
	@RequestMapping(value = "/editNotice" , method = RequestMethod.GET)
	public String editNoticeForm(@RequestParam("noticeid")int noticeid
	, Model model) throws Exception {
		model.addAttribute("noticeContent", boardservice.getNoticeContent(noticeid));
		model.addAttribute("noticeVO", new NoticeVO());
		return "noticeForm";
	}
	
	//faq �۾���
		@RequestMapping(value = "/editFaq" , method = RequestMethod.GET)
		public String editFaqForm(@RequestParam("faqid")int faqid
		, Model model) throws Exception {
			model.addAttribute("faqContent", boardservice.getFaqContent(faqid));
			model.addAttribute("faqVO", new FaqVO());
			return "faqForm";
		}
	
	//���� ����
	@RequestMapping(value = "/deleteNotice", method = RequestMethod.GET)
	public String deleteNoticeBoard(RedirectAttributes rttr, @RequestParam("noticeid") int noticeid) throws Exception {
		boardservice.deleteNotice(noticeid);
		return "redirect:/getNoticeList";
	}
	
	//faq ����
		@RequestMapping(value = "/deleteFaq", method = RequestMethod.GET)
		public String deleteFaqBoard(RedirectAttributes rttr, @RequestParam("faqid") int faqid) throws Exception {
			boardservice.deleteNotice(faqid);
			return "redirect:/getFaqList";
		}
}
