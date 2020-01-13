package com.biz.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.memo.domain.MemoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SessionAttributes({"dto","memoDTO"})
@RequestMapping(value = "/session")
@Controller
public class SessionController {

	//dto = new MemoDTO();
	@ModelAttribute("dto")
	public MemoDTO newMemoDTO() {
		return new MemoDTO();
	}
	//memoDTO = new MemoDTO();
	@ModelAttribute("memoDTO")
	public MemoDTO newMDTO() {
		return new MemoDTO();
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.GET)
	public String insert(@RequestParam("id") String str_seq,
			@ModelAttribute("dto") MemoDTO dto,Model model) {
		
		dto.setM_seq(8888);
		dto.setM_auth("박지민");
		dto.setM_date("2019-00-00");
		model.addAttribute("dto",dto);
		return "insert";
	}
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String insert(@ModelAttribute("dto") MemoDTO dto,Model model) {
		
		log.debug("SQ : " + dto.getM_seq());
		return "redirect:/memo/list";
	}
}
