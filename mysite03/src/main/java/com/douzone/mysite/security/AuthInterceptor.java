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
		System.out.println("auth : " + auth);
		
		//4. Handler Method에 @Auth가 없으면 Type(Class)에 붙어있는지 화인
		if(auth == null) {
			auth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);		
			System.out.println("admin : " + auth);
		}
				
		//5. Type이나 Method에 @Auth가 없는 경우
		if(auth == null) {
			return true;
		}
		
		//6. @Auth가 붙어있기 떄문에 인증(Authenfication) 여부 확인
		HttpSession session = request.getSession();
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		
		System.out.println(";;;;;;" + authUser);
				
		//인증이 안된 경우
		if(authUser == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			
			System.out.println("인증이 안된경우");
				
			return false;
		}
				
		//7. 권한(Authorization) 체크를 위해 !Auth의 role 가져오기("ADMIN", "USER")
		if( auth != null ) {
			String role = auth.role().toString();
			if( "ADMIN".equals(role) ) {
				if( "ADMIN".equals(authUser.getRole()) == false ){
					response.sendRedirect(request.getContextPath());
					return false;
				}
			}
		}
		
		System.out.println(request.getContextPath());
				
		String role = auth.role();
		// String AuthUserRole = authUser.getRole();
				
		//8. 인증 확인
		return true;
	}

}
