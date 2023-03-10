package com.douzone.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.douzone.mysite.service.UserService;
import com.douzone.mysite.vo.UserVo;

public class LoginInterceptor implements HandlerInterceptor {
	
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserVo vo = new UserVo();
		vo.setEmail(email);
		vo.setPassword(password);

		UserVo authUser = userService.getUser(vo);

		if(authUser == null) {
			request.setAttribute("email", vo.getEmail());
			request.getRequestDispatcher("/WEB_INF/views/user/login.jsp")
						.forward(request, response);
			
			return false;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("authUser", authUser);
		
		System.out.println("role");
		
		response.sendRedirect(request.getContextPath());

		return false;
	}

}
