package com.biz.memo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.memo.domain.MemoDTO;
import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

/*
 * SessionAttributes로 설정된 변수는 
 * response를 하기 전 서버의 기억장소 임시보관
 * web browser와 server간에 한번이라도 연결이 이루어졌으면
 * Session..에 등록된 변수는 서버가 중단될때까지 값이 유지
 * web은 특성상 클라이언트의 req를 서버가 받아서
 * res를 수행하고 나면 모든 정보가 사라지는 특성
 * 이런 특성과는 달리 Spring기반의 WEB은 일부 데이터들을 
 * 메모리에 보관했다가 재사용하는 기법이 있다
 * 그 중 sessionAttrinbutes라는 기능있다
 * 
 * sessionAttrinbutes()에 설정하는 문자열은
 * 클래스의 표준 객체생성 패턴에 의해 만들어진 이름이다
 * MemoDTO memoDTO
 * 
 * 이름을 표준 패턴이 아닌 임의의 이름으로 바꾸고 싶다
 */
@SessionAttributes("dto")
@Slf4j
@RequestMapping(value = "/memo")
@Controller
public class MemoController {

	/*
	 * SessionAttrinbutes를 사용하기 위해서는 반드시 해당변수를 생성하는 method가 controller에 있어야하고 해당
	 * method에 ModelAttribute("변수명")가 있어야 한다
	 */
	@ModelAttribute("dto")
	public MemoDTO makeMemoDTO() {
		MemoDTO dto = new MemoDTO();

		return dto;
	}

	@Autowired
	MemoService mService;
	// @GetMapping
	// @PostMapping

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String search, Model model) {
		List<MemoDTO> mList;
		if (search == null || search.isEmpty()) {
			mList = mService.getAllList();
		} else {
			mList = mService.getSearchList(search);
		}

		model.addAttribute("MEMO_LIST", mList);
		return "home";
	}

	/*
	 * SessionAttributes에서 설정한 변수(객체)는
	 * 
	 * @ModelAttribute를 설정해주어야한다 단, 5.x 이하에서는 필수 5.x이하에서는 선택
	 * 
	 * 만약 Attribute의 이름을 표준패턴이 아닌 임의 이름으로 사용할 경우
	 * 
	 * @ModelAttribute("객체이름")을 필수 지정
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("dto") MemoDTO dto, Model model, HttpSession httpSession) {

		UserDTO userDTO = (UserDTO) httpSession.getAttribute("userDTO");

		if (userDTO == null) {
			model.addAttribute("LOGIN_MSG", "TRY");
			return "redirect:/member/login";
		}

		model.addAttribute("dto", dto);
		return "insert";
	}

	/*
	 * insert POST가 dto를 수신할 때 입력 form에서 사용자가 입력한 값들이 있으면 그 값들을 dto의 필드변수에
	 * setting을하고 만약 없으면 메모리 어딘가에 보관중이 SessionAttrinbutes에 설정된 dto변수에서 값을 가져와서 비어있는
	 * 필드변수를 채워서 매개변수에 주입
	 * 
	 * 따라서 form에서 보이지 않아도 되는 값들은 별도의 코딩을 하지 않아도 자동으로 insert POST로 전송되는 효과를 낸다
	 * 
	 * 단, 이 기능을 효율적으로 사용하려면 jsp 코드에 Spring-form tag로 input를 코딩해야한다
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("dto") MemoDTO dto, Model model, String search, SessionStatus sStatus) {

		log.debug("SQ : " + dto.getM_seq());
		log.debug("AUTH : " + dto.getM_auth());
		log.debug("DATE : " + dto.getM_date());
		log.debug("TIME : " + dto.getM_time());

		int ret = mService.insert(dto);
		sStatus.setComplete();
		return "redirect:/memo/list";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(@RequestParam("id") String str_seq, @ModelAttribute MemoDTO dto, Model model,
			HttpSession hSession) {

		long m_seq = 0;
		
		try {
			m_seq = Long.valueOf(str_seq);

		} catch (Exception e) {
			// TODO: handle exception
		}
		dto = mService.getMemo(m_seq);
		UserDTO userDTO = (UserDTO) hSession.getAttribute("userDTO");
		if (userDTO != null && userDTO.getU_id().equals(dto.getM_auth())) {
			model.addAttribute("dto", dto);
			return "view";
		} else {
			model.addAttribute("LOGIN_MSG", "NO_AUTH");
			return "redirect:/member/login";
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, @ModelAttribute("dto") MemoDTO dto, Model model) {

		long m_seq = 0;
		log.debug("ID:" + id);
		try {
			m_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		dto = mService.getMemo(m_seq);
		model.addAttribute("dto", dto);

		return "insert";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute("dto") MemoDTO dto, Model model, SessionStatus sStatus) {

		int ret = mService.update(dto);
		sStatus.setComplete();

		return "redirect:/memo/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@ModelAttribute("dto") MemoDTO dto) {
		int ret = mService.delete(dto.getM_seq());
		return "redirect:/memo/list";
	}
}
