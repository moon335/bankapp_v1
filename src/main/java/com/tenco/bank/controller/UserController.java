package com.tenco.bank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.bank.dto.SignInFormDto;
import com.tenco.bank.dto.SignUpFormDto;
import com.tenco.bank.handler.exception.CustomRestfullException;
import com.tenco.bank.repository.model.User;
import com.tenco.bank.service.UserService;
import com.tenco.bank.util.Define;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired // DI 처리
	private UserService userService;
	
	@Autowired // DI 처리
	private HttpSession session;
	
	// http://localhost:8080/user/sign-up
	@GetMapping("/sign-up")
	public String signUp() {
		
		// prifix
		// suffix
		return "/user/signUp";
	}
	
	/**
	 * 회원 가입 처리
	 * @param signUpFormDto
	 * @return 리다이렉트 로그인 페이지
	 */
	@PostMapping("/sign-up")
	// JSON 형식으로 바꾸고 싶다면 @RequestBody 사용
	public String signUpProc(SignUpFormDto signUpFormDto) {
		
		// 1. 유효성 검사
		if(signUpFormDto.getUsername() == null || signUpFormDto.getUsername().isEmpty()) {
			throw new CustomRestfullException("username을 입력해주세요", HttpStatus.BAD_REQUEST);
		}
		if(signUpFormDto.getPassword() == null || signUpFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("password를 입력해 주세요.", HttpStatus.BAD_REQUEST);
		}
		if(signUpFormDto.getFullname() == null || signUpFormDto.getFullname().isEmpty()) {
			throw new CustomRestfullException("fullname을 입력해 주세요.", HttpStatus.BAD_REQUEST);
		}
		// 서비스 호출
		userService.createUser(signUpFormDto);
		
		return "redirect:/user/sign-in";
	}
	
	/**
	 * 로그인 폼
	 * @return 로그인 페이지 
	 */
	@GetMapping("/sign-in")
	public String signIn() {
		
		return "/user/signIn";
	}
	
	/**
	 * 로그인 처리
	 * 기본 파싱 전략 : key = value
	 * @param signUpFormDto
	 * @return 메인 페이지 이동(수정 예정)
	 * 생각해보기 
	 * GET 방식 처리는 브라우저 히스토리에 남겨지기 때문에
	 * 예외적으로 로그인 POST 방식으로 처리 한다. (보안)
	 */
	@PostMapping("/sign-in")
	public String signInProc(SignInFormDto signInFormDto) {
		
		// 1. 유효성 검사 (인증 검사가 필요한 페이지라면 인증 검사가 더 우선)
		if(signInFormDto.getUsername() == null || signInFormDto.getUsername().isEmpty()) {
			throw new CustomRestfullException("username을 입력하시오", HttpStatus.BAD_REQUEST);
		}
		
		if(signInFormDto.getPassword() == null || signInFormDto.getPassword().isEmpty()) {
			throw new CustomRestfullException("password 입력하시오", HttpStatus.BAD_REQUEST);
		}
		
		//   접근주체
		User principal = userService.signIn(signInFormDto);
		principal.setPassword(null);
		session.setAttribute(Define.PRINCIPAL, principal);
		
		return "redirect:/account/list";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/user/sign-in";
	}
	
} // end of class
