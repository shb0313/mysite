package com.douzone.mysite.web.mvc.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.GuestBookDao;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long no = Long.parseLong(request.getParameter("no"));
		String password = request.getParameter("password");
		
		new GuestBookDao().deleteByNoAndPassword(no, password);
		
		MvcUtil.redirect(request.getContextPath() + "/guestbook?a=list", request, response);

	}

}