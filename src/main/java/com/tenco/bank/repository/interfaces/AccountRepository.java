package com.tenco.bank.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tenco.bank.repository.model.Account;

@Mapper // MyBatis 연결
public interface AccountRepository {
	
	public int insert(Account account);
	public int updateById(Account account);
	public int deleteById(int id);
	
	public List<Account> findAll(); // 관리자용 모든 계좌 확인
	public Account findById(int id);
	public List<Account> findByUserId(Integer UserId); // 사용자의 모든 계좌
	
	// 코드 추가
	public Account findByNumber(String number);
	
}
