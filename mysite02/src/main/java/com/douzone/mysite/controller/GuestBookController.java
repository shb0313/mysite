package com.douzone.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.web.mvc.guestbook.GuestBookActionFactory;
<<<<<<< HEAD
=======
import com.douzone.mysite.web.mvc.main.MainActionFactory;
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
=======
		request.setCharacterEncoding("utf-8");
		
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
		String actionName = request.getParameter("a");
		
		ActionFactory af = new GuestBookActionFactory(); 
		Action action = af.getAction(actionName);
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}