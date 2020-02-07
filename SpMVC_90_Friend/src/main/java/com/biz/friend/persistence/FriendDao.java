package com.biz.friend.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.biz.friend.domain.FriendVO;

public interface FriendDao {

	@Select("SELECT * FROM tbl_friend")
	public List<FriendVO> selectAll();
	
	@Select("SELECT * FROM tbl_friend WHERE fr_num = #{fr_num}")
	public FriendVO findById(long fr_num);
	
	@Select("SELECT * FROM tbl_friend WHERE fr_name LIKE CONCAT ('%', #{fr_name},'%')")
	public List<FriendVO> findByName(String fr_name);
	
	public List<FriendVO> findByNameAndTell(String fr_name, String fr_tell);
	
	public int update(FriendVO friendVO);
	
	public int insert(FriendVO friendVO);
	
	@Delete("DELETE FROM tbl_friend WHERE fr_num = #{fr_num}")
	public int delete(long fr_num);


	
}
