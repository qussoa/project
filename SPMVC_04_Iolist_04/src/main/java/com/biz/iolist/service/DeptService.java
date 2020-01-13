package com.biz.iolist.service;

import java.util.ArrayList;
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

	/*
	 * service 클래스에서 deptDao가필요로 할때 spring이 자동으로 이 멧드를 호출하여 deptDao를 초기화 생성
	 */
	@Autowired
	public void getDeptDaoMapper() {

		dao = sqlSession.getMapper(DeptDao.class);
	}

	public List<DeptDTO> getAllList() {

		// dao = sqlSession.getMapper(DeptDao.class);

		List<DeptDTO> dList = dao.selectAll();

		return dList;
	}

	public int insert(DeptDTO dto) {

		// DeptDao dao = sqlSession.getMapper(DeptDao.class);
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

	public List<DeptDTO> selectNameSearch(String strText) {
		List<DeptDTO> dList = null;
		DeptDTO dto = dao.findByDCode(strText);
		if (dto != null) {
			dList = new ArrayList<DeptDTO>();
			dList.add(dto);
		} else {
			dList = dao.findByName(strText);
		}

		return dList;
	}
}
