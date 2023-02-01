package com.douzone.mysite.web.mvc.board;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long no = Long.parseLong(request.getParameter("no"));
		
		LocalTime now = LocalTime.now();
        int hour = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("HH")));
        int min = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("mm")));
        int sec = Integer.parseInt(now.format(DateTimeFormatter.ofPattern("ss")));

		Cookie viewCookie = null;
		Cookie[] cookies = request.getCookies();

		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (("cookie" + no).equals(cookie.getName())) {
					viewCookie = cookie;
				}
			}
		}

		if (viewCookie == null) {
			Cookie newCookie = new Cookie("cookie" + no, "|" + no + "|");
			newCookie.setMaxAge((24 * 3600) - (hour * 3600 + min * 60 + sec));
			response.addCookie(newCookie);
			new BoardDao().updateHit(no);
		}
		
		BoardVo boardVo = new BoardDao().findByNo(no);
		request.setAttribute("boardVo", boardVo);
		MvcUtil.forward("board/view", request, response);
	}
}
