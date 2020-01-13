package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.domain.UserDTO;
import com.biz.memo.persistence.UserDao;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	SqlSession sqlSession;
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
		return uDao.userInsert(userDTO);
	}

	@Override
	public boolean userIdCheck(String u_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean userLoginCheck(UserDTO userDTO) {
		String inU_id = userDTO.getU_id();
		String inU_pass = userDTO.getU_password();

		UserDTO userRDTO = uDao.findById(inU_id);
		
		// 회원 아이디가 없을경우
		if(userRDTO == null ) {
			return false;
		}
		
		String sU_id = userRDTO.getU_id();
		String sU_pass = userRDTO.getU_password();

		// 비밀번호 틀렸을 경우
		if (sU_id.equalsIgnoreCase(inU_id) && sU_pass.equals(inU_pass)) {
			
			/*
			 * java method에서 객체를 매개변수로 받은 후 
			 * 각 필드변수들을 개별적으로 변경을 하면
			 * 파라메터로 주입한 원본의 변수값들이 변경된다
			 * 
			 * 하지만 
			 * 객체 = 다른객체
			 * 또는 객체 = new 클래스() 형식으로
			 * 자체를 변경해버리면
			 * 파라메터로 주입한 원본은 변경이 되지 않는다
			 * userDTO = userRDTO;
			 * 
			 * 그래서 이경우 각 필드변수 요소들을 모두 주입해주어야한다
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
