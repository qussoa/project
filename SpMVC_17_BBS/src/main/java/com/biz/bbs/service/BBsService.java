package com.biz.bbs.service;

import java.util.List;

import com.biz.bbs.domain.BBsVO;

public interface BBsService {

	public List<BBsVO> selectAll();

	public BBsVO findById(long bbs_id);

	// 리스트로 만들어 제목으로 검색
	public List<BBsVO> findBySubjects(String subject);

	// 리스트로 만들어 작성자로 검색
	public List<BBsVO> findByWriters(String writer);

	// 제목과 작성자로 검색
	public List<BBsVO> findBySubjectAndWriter(String subject, String writer);
	
	// insert update 처리할 service
	public int save(BBsVO bbsVO);

	public int delete(long bbs_id);

	public BBsVO replay(BBsVO bbsVO);
}
