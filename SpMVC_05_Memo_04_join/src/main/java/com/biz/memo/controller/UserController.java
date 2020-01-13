package com.biz.memo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.domain.HobbyDTO;
import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/user")
@Controller
public class UserController {

	@Autowired
	UserService uService;
	
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join(Model model) {
		
		//UserDTO userDTO = new UserDTO();
		UserDTO userDTO = UserDTO.builder().build();
		
		//취미리스트
		List<HobbyDTO> hList = uService.getHobbyList();
		
		model.addAttribute("HO_LIST",hList);
		log.debug(hList.toString());
		
		/*
		 * String[] strH= new String[] {hList.get(0).getH_code(),
		 * hList.get(3).getH_code()}; userDTO.setU_hobby(strH);
		 */
		model.addAttribute("userDTO",userDTO);
		
		return "user/insert";
	}
	
	@RequestMapping(value = "/join", method=RequestMethod.POST)
	public String join(@ModelAttribute UserDTO userDTO, Model model) {
		
		int ret = uService.userJoin(userDTO);
		return "redirect:/memo/list";
	}
}
