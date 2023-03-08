package com.douzone.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.GuestBookRepository;
import com.douzone.mysite.vo.GuestBookVo;

@Service
public class GuestBookService {
	
	@Autowired
	private GuestBookRepository guestbookRepository;
	
	public List<GuestBookVo> getMessageList() {
		return guestbookRepository.findAll();
	}
	
	public List<GuestBookVo> getMessageList(Long startNo) {
				
		return guestbookRepository.findList(startNo);
	}
	
	public Boolean deleteMessage(Long no, String password) {	
				
		return 1 == guestbookRepository.deleteByNoAndPassword(no, password);
	}
	
	public void addMessage(GuestBookVo vo) {
		guestbookRepository.insert(vo);
	}
}
