package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.domain.MemoDTO;
import com.biz.memo.persistence.MemoDao;

@Service
public class MemoService {

	@Autowired
	SqlSession sqlSession;

	MemoDao dao;

	/*
	 * Service를 사용하려고 시도하면 sqlSession으로부터 MemoDao mapper를 추출하여 dao 객체를 사용할 수 있도록 초기화
	 */
	@Autowired
	public void getMapper() {
		dao = sqlSession.getMapper(MemoDao.class);
	}

	public List<MemoDTO> getAllList() {
		// MEMO의 전체 리스트를 DB로부터 가져와 Controller로 리턴

		return dao.selectAll();
	}

	public List<MemoDTO> getSearchList(String m_subject) {
		// TODO 제목으로 검색
		MemoDTO dto = MemoDTO.builder().m_subject(m_subject).build();
		return dao.findBySearch(dto);
	}

	public int insert(MemoDTO dto) {
		
		return dao.insert(dto);
	}

	public MemoDTO getMemo(long m_seq) {
		
		MemoDTO dto = dao.findById(m_seq);
		
		return dto;
	}

	public int update(MemoDTO dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	public int delete(long m_seq) {
		// TODO Auto-generated method stub
		return dao.delete(m_seq);
	}
}
