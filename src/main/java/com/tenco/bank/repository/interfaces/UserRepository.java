package com.tenco.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.bank.dto.SignInFormDto;
import com.tenco.bank.dto.SignUpFormDto;
import com.tenco.bank.repository.model.User;

@Mapper // MyBatis 의존 설정 되어 있어서 어노테이션 사용 가능(build.gradle 파일)
public interface UserRepository {
	// 코드 수정
	public int insert(SignUpFormDto SignUpFormDto);
	public int updateById(User user);
	public int deleteById(Integer id);
	public User findById(Integer id);
	public List<User> findAll();
	
	// 추가 작업
	public User findByUsernameAndPassword(SignInFormDto signInFormDto);
	
}
