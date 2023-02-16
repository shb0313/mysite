package com.douzone.mysite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
=======
import com.douzone.mysite.web.mvc.main.MainActionFactory;
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
import com.douzone.mysite.web.mvc.user.UserActionFactory;
import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

<<<<<<< HEAD
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String actionName = request.getParameter("a");
		
		ActionFactory af = new UserActionFactory(); 
		Action action = af.getAction(actionName);
		action.execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
=======

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String actionName = request.getParameter("a");
		
		ActionFactory af = new UserActionFactory();
		Action action = af.getAction(actionName);
		action.execute(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	}

}
>>>>>>> 2b257a6f0386d1a0f57f03db7dd0004482f952a7
