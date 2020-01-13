package com.biz.memo.service;

import com.biz.memo.domain.UserDTO;


public interface UserService {

	//회원가입
	public int userJoin(UserDTO userDTO);
	
	//아이디 중복
	public boolean userIdCheck(String u_id);
	
	//로그인
	public boolean userLoginCheck(UserDTO userDTO);

	public UserDTO getUser(String u_id);
}
