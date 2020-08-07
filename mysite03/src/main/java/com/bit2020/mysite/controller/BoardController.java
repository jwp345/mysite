package com.bit2020.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2020.mysite.security.Auth;
import com.bit2020.mysite.security.AuthUser;
import com.bit2020.mysite.service.BoardService;
import com.bit2020.mysite.vo.BoardVo;
import com.bit2020.mysite.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("")
	public String list(Model model) {
		List<BoardVo> list = boardService.getTextList();
		model.addAttribute("list", list);
		return "board/list";
	}
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@AuthUser UserVo authUser, BoardVo vo) {
		vo.setUserNo(authUser.getNo());
		boardService.write(vo);
		return "redirect:/board";
	}
	
	@RequestMapping("/view/{no}")
	public String view(@PathVariable("no") long no, Model model) {
		BoardVo vo = boardService.findbyNo(no);
		boardService.hit(vo.getNo());
		model.addAttribute("vo", vo);
		return "board/view";
	}
	
	@Auth
	@RequestMapping("/update/{no}")
	public String update(@PathVariable("no") long no, Model model) {
		BoardVo vo = boardService.findbyNo(no);
		model.addAttribute("vo", vo);
		return "board/modify";
	}
	
	@Auth
	@RequestMapping(value="/update/{no}", method=RequestMethod.POST)
	public String update(@PathVariable("no") long no, BoardVo vo) {
		BoardVo cur = boardService.findbyNo(no);
		cur.setContent(vo.getContent());
		cur.setTitle(vo.getTitle());
		boardService.update(cur);
		return "redirect:/board";
	}
	
	@Auth
	@RequestMapping(value="/delete/{no}")
	public String delete(@PathVariable("no") long no) {
		BoardVo vo = boardService.findbyNo(no);
		boardService.delete(vo);
		return "redirect:/board";
	}
}
