package com.bit2020.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2020.mysite.repository.UserRepository;
import com.bit2020.mysite.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void join(UserVo userVo) {
		userRepository.save(userVo);
	}

	public UserVo getUser(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public UserVo getUser(Long no) {
		
		UserVo userVo = userRepository.findByNo(no);
		return userVo;
	}

	public void updateUser(UserVo userVo) {
		userRepository.updateByEmail(userVo);
	}
}
