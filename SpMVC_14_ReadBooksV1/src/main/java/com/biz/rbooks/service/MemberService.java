package com.biz.rbooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.MemberDTO;
import com.biz.rbooks.repository.MemberDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {

	private final MemberDao mDao;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public MemberService(MemberDao mDao, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.mDao = mDao;
		this.passwordEncoder = passwordEncoder;
	}
	
	public int insert(MemberDTO memberDTO) {
		if(memberDTO.getM_password() == null || memberDTO.getM_password().isEmpty()) {
			
			return 0;
		}
		String cryptText = passwordEncoder.encode(memberDTO.getM_password());
		memberDTO.setM_password(cryptText);
		memberDTO.setM_id(memberDTO.getM_id());
		return mDao.insert(memberDTO);			
	}
	
	public boolean loginCheck(MemberDTO memberDTO) {
		
		String m_id = memberDTO.getM_id();
		String m_password = memberDTO.getM_password();
		
		MemberDTO loginMemberDTO = mDao.findById(m_id);
		
		if(loginMemberDTO != null) {
			String cryptPassword = loginMemberDTO.getM_password();
			if(passwordEncoder.matches(m_password, cryptPassword)) {
				return true;
			}
		}
		return false;
	}	
	
	public MemberDTO findById(MemberDTO memberDTO) {
		return mDao.findById(memberDTO.getM_id());
	}
	
	public int update(MemberDTO memberDTO) {
		return mDao.update(memberDTO);
	}
}
