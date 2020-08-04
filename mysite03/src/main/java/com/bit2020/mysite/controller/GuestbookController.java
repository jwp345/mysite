package com.bit2020.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2020.mysite.repository.GuestbookRepository;
import com.bit2020.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/gb")
public class GuestbookController {
	
	@Autowired
	private GuestbookRepository guestbookRepository;
	@RequestMapping("")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "/guestbook/list";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String form(@PathVariable("no") long no, Model model) 
	{	
		model.addAttribute("no", no);
		return "/guestbook/deleteform";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestbookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/gb/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam(value="no", required=true, defaultValue="0") long no,
			@RequestParam(value="password", required=true, defaultValue="") String password) {
		guestbookRepository.delete(no, password);
		return "redirect:/gb/";
	}
}
