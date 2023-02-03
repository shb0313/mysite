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
	private static final int LIST_SIZE = 5; // 리스팅되는 게시물의 수
	private static final int PAGE_SIZE = 5; // 페이지 리스트의 페이지 수
	
	@Autowired
	private BoardRepository boardRepository;
	
	public void addContents(BoardVo vo) {
		boardRepository.insert(vo);		
	}

	
	public BoardVo getContents(Long no) {
		return boardRepository.findByNo(no);
	}
	
	
	public void addReplyContents(BoardVo vo) {
		System.out.println("ser - ARC");
		
		
		BoardVo prevVo = boardRepository.findByNo(vo.getNo());
		System.out.println("prev" + vo);
		
		
		boardRepository.updateContentsOrder(prevVo);
		System.out.println("p" + prevVo);
		
		vo.setgNo(prevVo.getgNo());
		vo.setoNo(prevVo.getoNo());
		vo.setDepth(prevVo.getDepth());
		
		
		System.out.println("v" + vo);
		
		boardRepository.insertReply(vo);
	}
	
	public void updateContents(BoardVo vo) {
		boardRepository.update(vo);
	}
	
	public void deleteContents(Long no) {
		boardRepository.delete(no);
	}
	
	public Map<String, Object> getContentsList(int page, String keyword) {
		int totalCount = boardRepository.getTotalCount(keyword);
		
		// 1. view에서 게시판 리스트를 렌더링 하기 위한 데이터 값 계산
		int beginPage = 1;
		int endPage = totalCount/LIST_SIZE + 1;
		int prevPageList = (page - 1) / PAGE_SIZE * PAGE_SIZE;
		int nextPageList = (page - 1) / PAGE_SIZE * PAGE_SIZE + 6;

		//2. 리스트 가져오기
		List<BoardVo> list = boardRepository.findAllByPageAndKeyword(page, keyword, LIST_SIZE);
		
		//3. 리스트 정보를 map에 저장
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("list", list);
		map.put("beginPage", beginPage);
		map.put("endPage", endPage);
		map.put("prevPage", prevPageList);
		map.put("nextPage", nextPageList);
		map.put("pageSize", PAGE_SIZE);
		
		
		return map;
	}


}