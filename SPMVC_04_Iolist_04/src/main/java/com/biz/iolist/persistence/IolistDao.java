package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;

public interface IolistDao {

	public List<IolistVO> viwSelectAll();

	public int insert(IolistDTO dto);

	public IolistVO findBySeq(long io_seq);

}
