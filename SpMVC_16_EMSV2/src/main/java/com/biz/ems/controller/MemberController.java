package com.biz.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.ems.domain.NaverMember;
import com.biz.ems.domain.NaverReturnAuth;
import com.biz.ems.domain.NaverTokenVO;
import com.biz.ems.service.NaverLoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/member")
@Controller
public class MemberController {

	private final NaverLoginService nLoginservice;

	@RequestMapping(value = "/naver", method = RequestMethod.GET)
	public String naver_login() {

		String apiURL = nLoginservice.oAuthLoginGet();

		return "redirect:" + apiURL;
	}
	
	
	/*
	 * 네이버에 로그인 요청을 보낼 때 네이버가 return할 URL 부분
	 * 외부에서 접속할 수 있는 URL이어야 한다
	 * 
	 * 네이버에 로그인이 성공하면 실제로 네이버에서 데이터를 로그인 인증정보를
	 * 보내준다
	 */
	
	@ResponseBody
	@RequestMapping(value = "/naver/ok",method=RequestMethod.GET)
	public NaverMember naverOk(@ModelAttribute NaverReturnAuth naverok){
				
		NaverTokenVO nToken = nLoginservice.oAuthAcessGetToken(naverok);
		
		NaverMember memberVO = nLoginservice.getNaverMemberInfo(nToken);
				
		return memberVO;
	}
	
}
