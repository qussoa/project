package com.biz.iolist.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.iolist.domain.DeptDTO;

public interface DeptDao {

	public String getDCode();
	
	public List<DeptDTO> selectAll();
	public List<DeptDTO> findAll();
	public int insert(DeptDTO dto);

	public DeptDTO findByDCode(String d_code);

	public int delete(String d_code);

	public int update(DeptDTO dto);

	public List<DeptDTO> findByName(@Param("d_name") String strText);


}
