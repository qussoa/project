package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.memo.domain.UserDTO;
import com.biz.memo.persistence.UserDao;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	SqlSession sqlSession;
	
	
	@Autowired
	BCryptPasswordEncoder passwordEncorder;
	
	UserDao uDao;

	@Autowired
	public void newUserDao() {
		uDao = sqlSession.getMapper(UserDao.class);
	}

	@Override
	public int userJoin(UserDTO userDTO) {
		// TODO Auto-generated method stub

		if (uDao.userCount() > 0) {
			userDTO.setU_grade("U");
		} else {
			userDTO.setU_grade("A");
		}
		String cryptText = passwordEncorder.encode(userDTO.getU_password());
		userDTO.setU_password(cryptText);
		return uDao.userInsert(userDTO);
	}

	@Override
	public boolean userIdCheck(String u_id) {

		UserDTO userDTO = uDao.findById(u_id);
	
		if(userDTO != null && userDTO.getU_id().equalsIgnoreCase(u_id)) {
			return true;
		}		
		return false;
	}

	@Override
	public boolean userLoginCheck(UserDTO userDTO) {
		
		String inU_id = userDTO.getU_id();	
		String inU_pass = userDTO.getU_password();

		UserDTO userRDTO = uDao.findById(inU_id);
		
	
		if(userRDTO == null ) {
			return false;
		}
		
		String sU_id = userRDTO.getU_id();		
		// 사용자가 로그인하면서 입력한 비번
		// 평문인 상태의 비번
		// String sU_pass = userRDTO.getU_password();
		String cryptU_pass = userRDTO.getU_password();
		
		if (sU_id.equalsIgnoreCase(inU_id) &&	//sU_pass.equals(inU_pass)) {			
		
			passwordEncorder.matches(inU_pass, cryptU_pass)){
			/*
			 * BCrypt로 암호화된 문자열은 equal()등의 method로 matches() 되는지 비교가
			 * 불가능하고 BCrypt에서 지원하는 matches() method를 사용하여
			 * matches가 되는지 확인한다 
			 */
			userDTO.setU_grade(userRDTO.getU_grade());
			
			return true;
		} else {
			return false;
		}

	}

	@Override
	public UserDTO getUser(String u_id) {
		return uDao.findById(u_id);
	}

}
