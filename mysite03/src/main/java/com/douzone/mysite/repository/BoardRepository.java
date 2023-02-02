package com.douzone.mysite.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.mysite.vo.BoardVo;

@Repository
public class BoardRepository {
	@Autowired
	private SqlSession sqlSession;

	public List<BoardVo> findAllByPageAndKeyword(int page, String keyword, int size) {
		Map<String, Object> map = new HashMap<>();
		map.put("startOffset", (page - 1) * size);
		map.put("size", size);
		map.put("keyword", keyword);

		System.out.println("rep - fABPAK");

		return sqlSession.selectList("board.findAllByPageAndKeyword", map);
	}

	public int getTotalCount(String keyword) {
		System.out.println("rep - getTC");

		return sqlSession.selectOne("board.getTotalCount", keyword);
	}

	public String insert(BoardVo vo) {
		sqlSession.insert("board.insert", vo);
		System.out.println("rep - insert");
		return "redirect:/board";
	}

}