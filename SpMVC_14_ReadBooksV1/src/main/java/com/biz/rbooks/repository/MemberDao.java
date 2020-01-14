package com.biz.rbooks.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.rbooks.domain.MemberDTO;

public interface MemberDao {


	@Select("SELECT * FROM tbl_member WHERE m_id = #{m_id}" )
	public MemberDTO findById(String m_id);
	
	@Insert("INSERT INTO tbl_member (m_id, m_password,m_login_date,m_rem)"
			+"VALUES(#{m_id, jdbcType=VARCHAR},#{m_password, jdbcType=VARCHAR}, #{m_login_date,jdbcType=VARCHAR}, #{m_rem,jdbcType=VARCHAR})")
	public int insert(MemberDTO memberDTO);

	@Update("UPDATE tbl_member SET m_login_date = #{m_login_date} WHERE m_id = #{m_id} ")
	public int update(MemberDTO memberDTO);
}
