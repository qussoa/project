package com.biz.bbs.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.service.BBsService;

@SessionAttributes("bbsVO")
@RequestMapping(value = "/bbs")
@Controller
public class BBsController {

	private final BBsService bService;

	@Autowired
	public BBsController(@Qualifier("bServiceV1") BBsService bService) {
		super();
		this.bService = bService;
	}
	
	@ModelAttribute("bbsVO")
	public BBsVO makeBBsVO() {
		return new BBsVO();
	}
	/*
	 * view method에서 @ModelAttribute를 사용한 이유
	 * 게시판 상세페이지(view)에서 답글을 작성할 때
	 * 본문만 작성하는 textarea box를 두고 나머지 항목들은
	 * 별도로 저장하지 않아도 답글을 저장했을 때 원글의 내용이
	 * 같이 controller로 전송할 수 있도록 하는 설정
	 * 
	 * @ModelAttribute로 설정된 bbsVO는 sessionAttributes에 설정되어 있기 때문에
	 * 
	 * add.modelAttribute로 만드는 순간 서버 session메모리에 데이터가 저장되어 있어
	 * 다른 method에서 그 값을 참조 할 수 있다
	 */
	
	@RequestMapping(value = "/view", method=RequestMethod.GET)
	public String view(@ModelAttribute BBsVO bbsVO, long bbs_id, Model model) {
		
		
		bbsVO = bService.findById(bbs_id);
	//	bbsVO.setBbs_writer("");
		
		
		model.addAttribute("bbsVO",bbsVO);
		model.addAttribute("BODY","BBS_VIEW");
		
		return "home";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectAll(Model model) {
		List<BBsVO> bbsList = bService.selectAll();
		model.addAttribute("BBS_LIST", bbsList);
		model.addAttribute("BODY", "BBS_LIST");

		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model) {
		
		// java 1.8 이상의 새로운 날짜 시간 클래스
		LocalDate ld = LocalDate.now();
		LocalTime lt = LocalTime.now();
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		BBsVO bbsVO = BBsVO.builder()
				.bbs_date(ld.toString())
				.bbs_time(lt.format(dt))
				.build();

		model.addAttribute("bbsVO", bbsVO);
		model.addAttribute("BODY", "BBS_INPUT");

		return "home";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute BBsVO bbsVO) {
		
		bService.save(bbsVO);

		return "redirect:/bbs/list";
	}

	@RequestMapping(value = "replay",method=RequestMethod.POST)
	public String replay(@ModelAttribute("bbsVO") BBsVO bbsVO, Model model) {
		
		
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter ld = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter lt = DateTimeFormatter.ofPattern("HH:mm:ss");
		bbsVO.setBbs_date(ldt.format(ld));
		bbsVO.setBbs_time(ldt.format(lt));
		
		bbsVO = bService.replay(bbsVO);
		
		return "redirect:/bbs/list";
	}
	
}
