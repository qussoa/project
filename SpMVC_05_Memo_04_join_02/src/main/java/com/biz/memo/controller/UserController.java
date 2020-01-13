package com.biz.memo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/user")
@Controller
public class UserController {

	@Autowired
	UserService uService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {

		UserDTO userDTO = new UserDTO();
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("BODY", "JOIN");
		return "user/insert";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("userDTO") @Valid UserDTO userDTO, BindingResult bResult, Model model) {

		if (bResult.hasErrors()) {
			return "user/insert";
		} else {
			int ret = uService.userJoin(userDTO);

			return "redirect:/memo/list";

		}

	}

	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String myPage(Model model, HttpSession httpSession) {

		UserDTO userDTO = (UserDTO) httpSession.getAttribute("userDTO");

		model.addAttribute("userDTO", userDTO);
		model.addAttribute("TITLE", "회원정보수정");

		return "user/insert";
	}
}
