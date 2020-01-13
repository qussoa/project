package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rbooks.domain.ReadBookDTO;

public interface BookReadDao {

	@Select("SELECT * FROM tbl_read_book")
	public List<ReadBookDTO> selectAll();
	
	@Select("SELECT * FROM tbl_read_book WHERE rb_seq = #{rb_seq}")
	public ReadBookDTO findBySeq(long rb_seq);

	@InsertProvider(type = BookSQL.class,method = "rbinsert_sql")
	public int insert(ReadBookDTO readBookDTO);

	@Select("SELECT * FROM tbl_read_book WHERE rb_bcode = #{rb_bcode}")
	public List<ReadBookDTO> findByRBCode(String rb_bcode);

	@UpdateProvider(type = BookSQL.class,method = "rbupdate_sql")
	public int update(ReadBookDTO readBookDTO);
	
	@Delete("DELETE FROM tbl_read_book WHERE rb_seq = #{rb_seq}")
	public int delete(long rb_seq);
}
