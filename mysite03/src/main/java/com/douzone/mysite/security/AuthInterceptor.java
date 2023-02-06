package com.douzone.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.douzone.mysite.vo.UserVo;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1. handler 종류 확인
		if(!(handler instanceof HandlerMethod)) {
			//DefaultServletHandler가 처리하는 경우(정적 자원, /assets/**)
			return true;
		}
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//3. Handler Method의 @Auth 가져오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		//4. @Auth가 안되어있는 경우
		if(auth == null) {
			return true;
		}
		
		//5. @Auth가 붙어있기 떄문에 인증(Authenfication) 여부 확인
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		//인증이 안된 경우
		if(authUser == null) {
			response.sendRedirect(request.getContextPath() + "user/login");
			return false;
		}
		
		//6. 인증 확인
		return true;
	}

}
