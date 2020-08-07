package com.bit2020.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2020.mysite.repository.BoardRepository;
import com.bit2020.mysite.vo.BoardVo;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;

	public List<BoardVo> getTextList() {
		return boardRepository.findAll();
	}

	public void write(BoardVo vo) {
		boardRepository.save(vo);
	}

	public BoardVo findbyNo(long no) {
		return boardRepository.findbyNo(no);
	}

	public void update(BoardVo vo) {
		boardRepository.update(vo);
	}

	public void delete(BoardVo vo) {
		boardRepository.delete(vo);
	}

	public void hit(long no) {
		boardRepository.hit(no);
	}
	
}
