package com.douzone.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.mysite.service.GuestBookService;
import com.douzone.mysite.vo.GuestBookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {

	@Autowired
	private GuestBookService guestbookService;
	
	@RequestMapping("/list")
	public String list(HttpSession session) {
		List<GuestBookVo> list = guestbookService.getMessageList();
		session.setAttribute("list", list);
		return "guestbook/list";
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)
	public String delete(Long no) {
		return "guestbook/delete";
	}

	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(Long no, String password) {		
		guestbookService.deleteMessage(no, password);		
		return "redirect:/guestbook/list";
	}

	@RequestMapping("/add")
	public String add(GuestBookVo vo) {
		guestbookService.addMessage(vo);	
		return "redirect:/guestbook/list";
	}
	
	@RequestMapping("/spa")
	public String indexSPA() {
		
		return "guestbook/index-spa";
	}

}
