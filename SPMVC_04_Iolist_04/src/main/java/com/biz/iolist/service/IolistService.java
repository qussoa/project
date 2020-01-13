package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;
import com.biz.iolist.persistence.IolistDao;

@Service
public class IolistService {

	@Autowired
	SqlSession sqlSession;
	
	IolistDao dao;
	
	@Autowired
	public void getMapper() {
		dao = sqlSession.getMapper(IolistDao.class);
	}

	public List<IolistVO> viewAllList() {
		
		List<IolistVO> iolist = dao.viwSelectAll();
		return iolist;
	}
	
	public int insert(IolistDTO dto) {
		int ret = dao.insert(dto);
		return 0;
	}

	public IolistVO findBySeq(long io_seq) {

		IolistVO vo = dao.findBySeq(io_seq);
		return vo;
	}
}
