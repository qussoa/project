package com.biz.rbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.ReadBookDTO;
import com.biz.rbooks.repository.BookReadDao;

@Service
public class ReadService {

	private final BookReadDao readDao;

	@Autowired
	public ReadService(BookReadDao readDao) {
		super();
		this.readDao = readDao;
	}
	
	public List<ReadBookDTO> selectAll() {
		return readDao.selectAll();
	}

	public List<ReadBookDTO> findByRBCode(String rb_bcode) {
		List<ReadBookDTO> readList = readDao.findByRBCode(rb_bcode);
		return readList;
	}

	public int insert(ReadBookDTO readBookDTO) {
		int ret = readDao.insert(readBookDTO); 
		return ret; 		
	}

	public ReadBookDTO findBySeq(long rb_seq) {
			ReadBookDTO readBookDTO = readDao.findBySeq(rb_seq);
		return readBookDTO;
	}

	public int update(ReadBookDTO readBookDTO) {

		int ret = readDao.update(readBookDTO);
		return ret;
	}
	
	public int delete(long rb_seq) {
		int ret = readDao.delete(rb_seq);
		return ret;
	}
	
}
