package com.biz.friend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.service.FriendService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/friend")
@Controller
public class FriendController {

	private final FriendService fService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectAll(Model model) {

		List<FriendVO> frList = fService.selectAll();
		model.addAttribute("FR_LIST", frList);
		model.addAttribute("BODY", "FR_LIST");
		return "home";
	}
	
	@RequestMapping(value = "/search",method=RequestMethod.GET)
	public String search(Model model,
			@RequestParam(value = "fr_name", required = false, defaultValue = "") String fr_name) {
		
		List<FriendVO> frList = new ArrayList<FriendVO>();
		
		if(fr_name == "") {
			frList = fService.selectAll();
		}else {
			frList = fService.findByName(fr_name);
		}
		model.addAttribute("FR_LIST",frList);
		
		return "home";
	}

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(@ModelAttribute("friendVO") FriendVO friendVO, Model model) {

		model.addAttribute("BODY", "FR_INPUT");

		return "home";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("friendVO") FriendVO friendVO, SessionStatus status) {

		fService.save(friendVO);
		int ret = fService.save(friendVO);
		status.setComplete();
		return "redirect:/friend/list";
	}

	@RequestMapping(value = "/save/{fr_num}", method = RequestMethod.GET)
	public String update(@PathVariable("fr_num") long fr_num, Model model) {

		FriendVO friendVO = fService.findById(fr_num);
		model.addAttribute("friendVO", friendVO);
		model.addAttribute("BODY","FR_INPUT");

		return "home";
	}

	@RequestMapping(value = "/delete/{fr_num}", method = RequestMethod.GET)
	public String delete(@PathVariable("fr_num") long fr_num) {

		int ret = fService.delete(fr_num);

		return "redirect:/friend/list";
	}

}
