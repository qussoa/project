package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.ProductDTO;
import com.biz.iolist.persistence.ProductDao;

@Service
public class ProductService {

	@Autowired
	SqlSession sqlSession;
	ProductDao dao;

	public List<ProductDTO> getAllList() {

		dao = sqlSession.getMapper(ProductDao.class);

		List<ProductDTO> proList = dao.selectAll();

		return proList;
	}

	public int insert(ProductDTO dto) {

		ProductDao dao = sqlSession.getMapper(ProductDao.class);
		/*
		 * 거래처 코드 자동생성 추가 DeptDTO d_code 저장
		 */
		String p_code = dao.getPCode();
		String p_code_num = p_code.substring(1);
		int intP_code = Integer.valueOf(p_code_num) + 1;

		p_code = p_code.substring(0, 1);
		p_code += String.format("%04d", intP_code);
		dto.setP_code(p_code);
		int ret = dao.insert(dto);

		return ret;
	}

	public ProductDTO findByPCode(String p_code) {

		ProductDTO dto = dao.findByPCode(p_code);

		return dto;
	}

	public int delete(String p_code) {

		int ret = dao.delete(p_code);
		return ret;

	}

	public int update(ProductDTO dto) {
		int ret = dao.update(dto);
		return ret;
	}
}
