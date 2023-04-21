package com.tenco.bank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tenco.bank.handler.AuthInterceptor;

@Configuration // IoC 등록
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Autowired // DI
	private AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor).addPathPatterns("/account/**").addPathPatterns("/auth/**"); // path 더 추가하는 방법
		
		// 인터셉터를 하나 더 등록하려면
//		registry.addInterceptor(new AdminInterceptor()).addPathPatterns();
	}
	
} // end of class
