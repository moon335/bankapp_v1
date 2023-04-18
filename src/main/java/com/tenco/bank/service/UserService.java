package com.tenco.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.bank.dto.SignUpFormDto;
import com.tenco.bank.handler.exception.CustomRestfullException;
import com.tenco.bank.repository.interfaces.UserRepository;

@Service // IoC 대상
public class UserService {
	
	@Autowired // DI 처리(객체 생성시 의존 주의 처리)
	private UserRepository userRepository;
	
	@Transactional 
	// 메서드 호출이 시작될 때 트랜잭션 시작
	// 메서드 종료시 트랜잭션 종료 (commit)
	public void signUp(SignUpFormDto signUpFormDto) {
		int result = userRepository.insert(signUpFormDto);
		if(result != 1) {
			throw new CustomRestfullException("회원 가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
} // end of class	