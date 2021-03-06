package com.biz.rbooks.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.service.BookService;
import com.biz.rbooks.service.ReadBookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/rbook")
@Controller
public class ReadBookController {

	private final ReadBookService rBookService;
	private final BookService bService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {

		List<ReadBookVO> rBookList = rBookService.selectAll();
		model.addAttribute("RBOOKS", rBookList);
		return "rbooks/list";
	}

	// 입력화면을 보여주기 위한 method
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(Model model) {

		ReadBookVO rBookVO = new ReadBookVO();

		// java 1.8에서 사용할 수 있는 날짜 클래스
		LocalDate localDate = LocalDate.now();
		String curDate = localDate.toString();
		
		DateTimeFormatter dt = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime localTime = LocalTime.now();
		String curTime = localTime.format(dt).toString();

		rBookVO.setRb_date(curDate);
		rBookVO.setRb_stime(curTime);

		model.addAttribute("rBookVO", rBookVO);

		return "rbooks/input";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ReadBookVO rBookVO) {

		int ret = rBookService.insert(rBookVO);

		return "redirect:/";
	}
	
	@RequestMapping(value = "/view/{rb_seq}",method=RequestMethod.GET)
	public String view(@PathVariable("rb_seq") long rb_seq, Model model) {
		
		ReadBookVO rBookVO = rBookService.findBySeq(rb_seq);
		model.addAttribute("RBOOK",rBookVO);
	
		String b_code = rBookVO.getRb_bcode();
		BookVO bookVO = bService.findByBcode(b_code);
		
		model.addAttribute("BOOK",bookVO);
		
		return "rbooks/view";
	}
	@RequestMapping(value = "/update/{rb_seq}",method=RequestMethod.GET)
	public String update(@PathVariable("rb_seq") long rb_seq, Model model) {
		
		ReadBookVO rBookVO = rBookService.findBySeq(rb_seq);
		model.addAttribute("rBookVO",rBookVO);
	
//		String b_code = rBookVO.getRb_bcode();
//		BookVO bookVO = bService.findByBcode(b_code);
//		
//		model.addAttribute("BOOK",bookVO);
		
		return "rbooks/input";
	}
	
}
