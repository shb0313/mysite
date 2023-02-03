package com.douzone.mysite.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.mysite.service.BoardService;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String index(int page, Model model) {		
		Map<String, Object> map = boardService.getContentsList(page, "");
		
		map.put("page", page);
		model.addAttribute("map", map);
		// model.addAllAttributes(map);
		
		System.out.println(map);
		
		return "board/list";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String add() {
		return "board/write";
	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String add(HttpSession session, BoardVo vo) {
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/board";
		}
		vo.setUserNo(authUser.getNo());
		
		System.out.println("write - " + vo);
		
		
		boardService.addContents(vo);
		return "redirect:/board";
	}
	
	@RequestMapping("/delete")
	public String delete(Long no) {
		boardService.deleteContents(no);		
		return "redirect:/board";
	}

	@RequestMapping("/view")
	public String view(HttpSession session, Long no) {
		//cookie 추가	
		session.setAttribute("boardVo", boardService.getContents(no));
		return "board/view";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(HttpSession session, Long no) {
		session.setAttribute("boardVo", boardService.getContents(no));
		return "board/modify";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(BoardVo vo) {
		boardService.updateContents(vo);
		return "board/view";
	}
	
	@RequestMapping(value = "/reply", method = RequestMethod.GET)
	public String reply(HttpSession session, Long no) {
		session.setAttribute("no", no);
		return "board/reply";
	}

	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public String reply(HttpSession session, Long no, BoardVo vo) {
		
		System.out.println("con:re" + no);
		
		
		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/board";
		}
		vo.setUserNo(authUser.getNo());
		vo.setNo(no);
		System.out.println("con-reply" + vo);
		
		boardService.addReplyContents(vo);
		return "redirect:/board";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}