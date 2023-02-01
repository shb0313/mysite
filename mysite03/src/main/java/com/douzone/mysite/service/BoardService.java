package com.douzone.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;

@Service
public class BoardService {
	
	private static final int List_size = 5; // 리스팅되는 게시물 수
	private static final int PAGE_size = 5; // 리스트 페이지 수
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	public void addContents(BoardVo vo) {
		
	}
	
	public BoardVo getContents(Long no) {
		
		
		
		return null;
	}
	
	
	//수정할때 
	public BoardVo getContents(Long no, Long userNo) {
		
		
		
		return null;
	}
	
	public void updateContents(BoardVo vo) {
		
	}
	
	public void deleteContents(Long no, Long userNo) {
		
	}
	
	public Map<String, Object> getContentsList(int page, String Keyword) {
		int totalCount = boardRepository.getTotalCount(Keyword);
		
		// 1. view에서 게시판 리스트를 렌더링하기 위한 데이터 값 계산
		int beginPage = 0;
		int prevPage = 0;
		int nextPage = 0;
		int endPage = 0;
		
		// 2. 리스트 가져오기
		List<BoardVo> list = boardRepository.findAllByPageAndKeyword(page, keyword);
		
		//3. 리스트 정보를 Map에 저장
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("beginPage", beginPage);
		map.put("nextPage", nextPage);
		map.put("endPage", endPage);
		
		
		
		
		return map;
	}
	
	
	
	
	
	
	
	
	
	
}
