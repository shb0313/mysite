package com.douzone.mysite.web.mvc.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.dao.BoardDao;
import com.douzone.mysite.vo.BoardVo;
import com.douzone.web.mvc.Action;
import com.douzone.web.util.MvcUtil;

public class ListAction implements Action {

	private static final int LIST_SIZE = 5; // 리스팅되는 게시물의 수
	private static final int PAGE_SIZE = 5; // 페이지 리스트의 페이지 수

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVo> list = new BoardDao().findAll();
		request.setAttribute("list", list);

		
		int page = Integer.parseInt(request.getParameter("page"));
		String keyword = request.getParameter("keyword");
		int totalCount = new BoardDao().getTotalCount(keyword);
				

		// 1. view에서 게시판 리스트를 렌더링 하기 위한 데이터 값 계산
		int beginPage = 1;
		int endPage = totalCount / LIST_SIZE + 1;
		int prevPageList = (page - 1) / PAGE_SIZE * PAGE_SIZE;
		int nextPageList = (page - 1) / PAGE_SIZE * PAGE_SIZE + 6;

		// 2. 리스트 가져오기
		List<BoardVo> list = boardRepository.findAllByPageAndKeyword(page, keyword, LIST_SIZE);

		// 3. 리스트 정보를 map에 저장
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("list", list);
		map.put("beginPage", beginPage);
		map.put("endPage", endPage);
		map.put("prevPage", prevPageList);
		map.put("nextPage", nextPageList);
		
		
		

		MvcUtil.forward("board/list", request, response);

	}

}
