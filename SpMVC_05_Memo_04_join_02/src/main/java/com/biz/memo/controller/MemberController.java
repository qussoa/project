package com.biz.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.UserService;

@RequestMapping(value = "/member")
@Controller
public class MemberController {

	@Autowired
	UserService uService;

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "LOGIN_MSG", required = false, defaultValue = "0") String msg,
			Model model) {
		model.addAttribute("LOGIN_MSG", msg);
		model.addAttribute("BODY", "LOGIN");
		return "member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String BODY,
			@ModelAttribute UserDTO userDTO, Model model, HttpSession httpSession) {

		boolean loginOk = uService.userLoginCheck(userDTO);

		if (loginOk == true) {
			httpSession.setMaxInactiveInterval(10 * 60);
			
			//DB로부터 사용자 정보를 가져오자
			userDTO = uService.getUser(userDTO.getU_id());
			httpSession.setAttribute("userDTO", userDTO);
		} else {
			httpSession.removeAttribute("userDTO");
			model.addAttribute("LOGIN_MSG","FAIL");
			return "redirect:/member/login";
		}

		/* model.addAttribute("BODY",BODY); */
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {

		httpSession.setAttribute("userDTO", null);
		httpSession.removeAttribute("userDTO");

		return "redirect:/";

	}
}
