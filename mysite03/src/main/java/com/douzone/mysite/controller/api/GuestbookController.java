package com.douzone.mysite.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.mysite.dto.JsonResult;
import com.douzone.mysite.service.GuestBookService;
import com.douzone.mysite.vo.GuestBookVo;

@RestController("guestbookApiController")
@RequestMapping("/guestbook/api")
public class GuestbookController {
	
	@Autowired
	private GuestBookService guestbookService;
	
	@GetMapping("")
	public JsonResult index(@RequestParam(value = "sno", required = true, defaultValue = "0") Long startNo) {
		
		List<GuestBookVo> list = new ArrayList<>();
		list = guestbookService.getMessageList(startNo);
		
		return JsonResult.success(list);
	}
	
	
	@PostMapping("")
	public JsonResult add(@RequestBody GuestBookVo vo) {
				
		guestbookService.addMessage(vo);
		
		return JsonResult.success(vo);	
	}

	@DeleteMapping("/{no}")
	public JsonResult delete(
			@PathVariable Long no, 
			@RequestBody String password) {
				
		boolean result = guestbookService.deleteMessage(no, password);
		
		System.out.println("DelCon: " + result);
		
		return JsonResult.success(result ? no : -1);
	}
	
	
	

}
