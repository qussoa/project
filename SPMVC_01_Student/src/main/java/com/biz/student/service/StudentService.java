package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.student.domain.StudentDTO;

@Service
public class StudentService {

	public List<StudentDTO> stdList() {
		List<StudentDTO> stdList = new ArrayList<StudentDTO>();

		StudentDTO dto = new StudentDTO();
		dto.setSt_num("0001");
		dto.setSt_name("Hong");
		dto.setSt_dept("Computer");
		dto.setSt_grade(3);
		dto.setSt_tel("010-0000-0000");
		stdList.add(dto);

		dto = new StudentDTO();
		dto.setSt_num("0002");
		dto.setSt_name("Mong");
		dto.setSt_dept("Computer");
		dto.setSt_grade(2);
		dto.setSt_tel("010-1111-1111");
		stdList.add(dto);
		
		dto = new StudentDTO();
		dto.setSt_num("0003");
		dto.setSt_name("Chun");
		dto.setSt_dept("Science");
		dto.setSt_grade(2);
		dto.setSt_tel("010-2222-2222");
		stdList.add(dto);
		return stdList;
	}

}
