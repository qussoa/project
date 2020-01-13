package com.biz.rbooks.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.rbooks.domain.MemberDTO;
import com.biz.rbooks.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/member")
@Controller
public class MemberController {

	private final MemberService mService;

	@Autowired
	public MemberController(MemberService mService) {
		super();
		this.mService = mService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "LOGIN_MSG", required = false, defaultValue = "0") String msg,
			Model model) {
		model.addAttribute("LOGIN_MSG",msg);
		
		
		return "body/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String BODY, @ModelAttribute MemberDTO memberDTO, Model model, HttpSession httpSession) {

		boolean loginOk = mService.loginCheck(memberDTO);

		if (loginOk == true) {
			httpSession.setMaxInactiveInterval(10 * 60);

			// DB로부터 사용자 정보를 가져오자
			memberDTO = mService.findById(memberDTO);
			Date date = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy년 MM월 dd일-");
			SimpleDateFormat st = new SimpleDateFormat("hh시 mm분 ss초");
			String mDate = sd.format(date);
			String tDate = st.format(date);
			memberDTO.setM_login_date(mDate + tDate);

			mService.update(memberDTO);
			httpSession.setAttribute("MEMBER", memberDTO);
		} else {
			httpSession.removeAttribute("MEMBER");

			return "redirect:/body/login";
		}
		/* model.addAttribute("BODY",BODY); */
		return "redirect:/list";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("MEMBER");
		return "redirect:/list";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(MemberDTO memberDTO, Model model) {

		model.addAttribute("MODAL", "JOIN");
		return "body/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model,MemberDTO memberDTO) {
		mService.insert(memberDTO);
		return "redirect:/";
	}

}
