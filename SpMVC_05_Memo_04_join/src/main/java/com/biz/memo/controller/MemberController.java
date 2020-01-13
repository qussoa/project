package com.biz.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.memo.domain.UserDTO;

/*
 * Controller에서 객체를 view로 보내는 방법
 * Model(ModelAndView),addAttribute()
 *  - 일회용 데이터 Controller -> view로 보내기만 하는 데이터
 *    Model에 담긴 데이터를 다시 서버로 보내려면 input tag에 값을 담아서 
 *    다시 POST 전송
 * SessionAttribute() ModelAndAttribute() 설정 후 model에 담기
 *  - 일회용 데이터이면서 session유지
 *    input View에서 Spring form tag에 값을 담으면 자유롭게 서버로 전송
 *    input, update 코딩을 간편하게 사용하는 용도 
 * 
 * HttpSession.setAttribute()에 담기
 *  - 주로 login과 관련된 데이터를 유지하기 위한 용도
 *    특별히 시간설정을 하거나, 값을 remove하거나
 *    서버가 멈출때까지 그 값을 유지하고 
 *    모든 Controller 모든 view에서 값을 참조할 수 있다
 *    server의 메모리 공간을 많이 차지하여 server 성능에 문제를 일으킬 수도 있다
 *    GC(Garbage Collection)을 적용할 수 없다
 *    표준 HTTP 프로토콜에 정의된 규격을 사용한다
 */
@RequestMapping(value = "/member")
@Controller
public class MemberController {

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {

		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(value = "LOGIN_MSG", required = false, defaultValue = "0") String msg,
			Model model) {
		model.addAttribute("LOGIN_MSG", msg);
		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserDTO userDTO, Model model, HttpSession httpSession) {

		UserDTO getuserDTO = UserDTO.builder().u_id("qussoa").u_password("12345").u_name("홍길동").u_tel("010-0000-0000")
				.build();

		if (userDTO.getU_id().equalsIgnoreCase(getuserDTO.getU_id())
				&& userDTO.getU_password().equals(getuserDTO.getU_password())) {
			httpSession.setAttribute("userDTO", getuserDTO);
		} else {
			// httpSession.setMaxInactiveInterval(10*60);
			httpSession.removeAttribute("userDTO");
		}

		return "redirect:/memo/list";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession httpSession) {

		httpSession.setAttribute("userDTO", null);
		httpSession.removeAttribute("userDTO");

		return "redirect:/memo/list";

	}
}
