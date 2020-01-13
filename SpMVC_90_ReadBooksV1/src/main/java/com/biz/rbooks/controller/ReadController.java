package com.biz.rbooks.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.rbooks.domain.BookDTO;
import com.biz.rbooks.domain.MemberDTO;
import com.biz.rbooks.domain.ReadBookDTO;
import com.biz.rbooks.service.ReadService;

@Controller
public class ReadController {

	@Autowired
	ReadService rService;

	@RequestMapping(value = "/rblist", method = RequestMethod.GET)
	public String view(Model model, @RequestParam("rb_bcode") String rb_code, HttpSession httpSession		) {

		List<ReadBookDTO> readList = new ArrayList<ReadBookDTO>();
		MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("memberDTO");

//		if (memberDTO == null) {
//			model.addAttribute("BODY", "LOGIN");
//			model.addAttribute("LOGIN_MSG", "TRY");
//			return "redirect:/member/login";
//		}
		readList = rService.findByRBCode(rb_code);
		model.addAttribute("READLIST", readList);

		return "/rblist";
	}

	@RequestMapping(value = "/rbinsert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("readBookDTO") ReadBookDTO readBookDTO, Model model) {

		readBookDTO = new ReadBookDTO();

		model.addAttribute("RBODY", "INSERT");
		model.addAttribute("readBookDTO", readBookDTO);

		return "/rbinsert";
	}

	@RequestMapping(value = "/rbinsert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("readBookDTO") ReadBookDTO readBookDTO) {
		rService.insert(readBookDTO);
		return "redirect:/rblist";
	}

	@RequestMapping(value = "/rbupdate", method = RequestMethod.GET)
	public String update(@RequestParam("id") long rb_seq, Model model) {
		ReadBookDTO readBookDTO = rService.findBySeq(rb_seq);
		model.addAttribute("readBookDTO", readBookDTO);
		return "/rbinsert";
	}

	@RequestMapping(value = "/rbupdate", method = RequestMethod.POST)
	public String update(ReadBookDTO readBookDTO, Model model) {
		int ret = rService.update(readBookDTO);
		return "redirect:/rblist";
	}

	@RequestMapping(value = "rbdelete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") long rb_seq) {
		int ret = rService.delete(rb_seq);
		return "redirect:/rblist";
	}
}
