package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.DeptDTO;
import com.biz.iolist.persistence.DeptDao;

@Service
public class DeptService {

	@Autowired
	SqlSession sqlSession;
	DeptDao dao;

	public List<DeptDTO> getAllList() {

		dao = sqlSession.getMapper(DeptDao.class);

		List<DeptDTO> deptList = dao.selectAll();

		return deptList;
	}

	public int insert(DeptDTO dto) {

		DeptDao dao = sqlSession.getMapper(DeptDao.class);
		/*
		 * 거래처 코드 자동생성 추가 DeptDTO d_code 저장
		 */
		String d_code = dao.getDCode();
		String d_code_num = d_code.substring(1);
		int intD_code = Integer.valueOf(d_code_num) + 1;

		d_code = d_code.substring(0, 1);
		d_code += String.format("%04d", intD_code);
		dto.setD_code(d_code);
		int ret = dao.insert(dto);

		return ret;
	}

	public DeptDTO findByDCode(String d_code) {

		DeptDTO dto = dao.findByDCode(d_code);

		return dto;
	}

	public int delete(String d_code) {

		int ret = dao.delete(d_code);
		return ret;

	}

	public int update(DeptDTO dto) {
		int ret = dao.update(dto);
		return ret;
	}
}
