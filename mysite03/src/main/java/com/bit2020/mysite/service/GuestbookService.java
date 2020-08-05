package com.bit2020.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2020.mysite.repository.GuestbookRepository;
import com.bit2020.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	@Autowired
	private GuestbookRepository guestbookRepository;

	public List<GuestbookVo> getMessageList() {
		return guestbookRepository.findAll();
	}

	public void addList(GuestbookVo vo) {
		guestbookRepository.insert(vo);
	}

	public void deleteVo(GuestbookVo vo) {
		guestbookRepository.delete(vo);
	}
}
