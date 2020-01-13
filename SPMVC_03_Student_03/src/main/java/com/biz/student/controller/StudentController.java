package com.biz.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.student.domain.StudentDTO;
import com.biz.student.service.StudentService;

@RequestMapping(value = "/student")
@Controller
public class StudentController {
	
	//@Inject : Java EE(EJB)에서 제공하는 기능
	@Autowired // Spring Framework의 고유 기능
			   // 이미 생성되어 컨테이너에 보관 중인
			   // StudentService instance를 가져가 sService를 
			   // 사용할 수 있도록 만들어주는 역할
	StudentService sService;
	
	/*
	 * StudentService의 getStdList() method를 호출 
	 * 학생정보가 담긴 List를 가져오고 view화면에
	 * rendering할 수 있도록 공급
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		model.addAttribute("BODY", "STUDENT-LIST");
		// return null;
		List<StudentDTO> stdList = sService.getStdList();
		model.addAttribute("STDLIST",stdList);
		
		return "home";

	}
}
