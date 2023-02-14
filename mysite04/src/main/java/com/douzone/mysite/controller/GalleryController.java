package com.douzone.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.mysite.security.Auth;
import com.douzone.mysite.service.FileuploadService;
import com.douzone.mysite.service.GalleryService;
import com.douzone.mysite.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	
	@Autowired
	private FileuploadService fileuploadService;
	
	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping("")
	public String index(String url, Model model) {
		
		List<GalleryVo> list = galleryService.getImages(url);
		model.addAttribute("list", list);
				
		return "gallery/index";
	}	
	
	@Auth(role="ADMIN")
	@RequestMapping("/upload")
	public String upload(MultipartFile file, GalleryVo galleryVo) {
		
		String url = fileuploadService.galleryStore(file);
		if(url != null) {
			galleryVo.setUrl(url);
		}
		galleryService.addImage(galleryVo);		
		return "redirect:/gallery";
	}
	
	@Auth(role="ADMIN")
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("no") Long no) {
		
		galleryService.removeImage(no);
		return "redirect:/gallery";
	}

}
