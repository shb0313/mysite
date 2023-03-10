package com.douzone.mysite.web.mvc.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long no = Long.parseLong(request.getParameter("no"));
		Long offset = Long.parseLong(request.getParameter("offset"));
		
		// 게시글 삭제
		new BoardDao().deleteByNo(no);
		
		MvcUtil.redirect(request.getContextPath() + "/board?offset=" + offset, request, response);
	}
}
