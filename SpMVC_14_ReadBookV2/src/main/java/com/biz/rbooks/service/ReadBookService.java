package com.biz.rbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.repository.ReadBookDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReadBookService {

	private final ReadBookDao rBookDao;

	public int insert(ReadBookVO rBookVO) {

		int ret = rBookDao.insert(rBookVO);

		return ret;
	}

	public List<ReadBookVO> selectAll() {
		return rBookDao.selectAll();
	}

	public ReadBookVO findBySeq(long rb_seq) {

		return rBookDao.findBySeq(rb_seq);
		
	}

}
