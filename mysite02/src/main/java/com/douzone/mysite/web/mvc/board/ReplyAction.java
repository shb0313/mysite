package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.mysite.vo.UserVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if(authUser == null) {
			MvcUtil.redirect(request.getContextPath(), request, response);
			return;
		}
		
		System.out.println("RA : " + request.getParameter("no"));
		
		
		Long no = Long.parseLong(request.getParameter("no"));
		String title = request.getParameter("title");
		String contents = request.getParameter("content");
		
		
		BoardVo vo = new BoardDao().findByNo(no);
		
		
		System.out.println("gno : " + vo.getgNo());
		System.out.println("ono : " + vo.getoNo());
		System.out.println("dep : " + vo.getDepth());
		
		
		
		
		new BoardDao().updateReply(vo.getgNo(), vo.getoNo());
		

		BoardVo replyVo = new BoardVo();
		replyVo.setTitle(title);
		replyVo.setContents(contents);
		replyVo.setgNo(vo.getgNo());
		replyVo.setoNo(vo.getoNo());
		replyVo.setDepth(vo.getDepth());
		replyVo.setUserNo(authUser.getNo());
		
		new BoardDao().insertReply(replyVo);
		MvcUtil.redirect(request.getContextPath() + "/board?a=list", request, response);

	}

}
