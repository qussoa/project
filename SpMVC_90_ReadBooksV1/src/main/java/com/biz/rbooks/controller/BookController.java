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
import com.biz.rbooks.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {

	@Autowired
	BookService bService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String search(Model model,
			@RequestParam(value = "b_name", required = false, defaultValue = "") String b_name) {

		log.debug("LIST");

		List<BookDTO> bList = new ArrayList<BookDTO>();

		if (b_name == "") {
			bList = bService.selectAll();
		} else {
			bList = bService.selectNameSearch(b_name);
		}

		model.addAttribute("BOOKLIST", bList);

		log.debug(bList.toString());

		return "list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(@ModelAttribute("bookDTO") BookDTO bookDTO, Model model, HttpSession httpSession
			) {
		
		bookDTO = new BookDTO();
	
		model.addAttribute("BODY", "INSERT");
		model.addAttribute("bookDTO", bookDTO); // 왜 있는 코드인가?

		log.debug(bookDTO.toString());

		return "insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("bookDTO") BookDTO bookDTO) {
		log.debug(bookDTO.toString());
		bService.insert(bookDTO);
		return "redirect:/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String b_code) {

		int ret = bService.delete(b_code);
		return "redirect:/list";

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam("id") String b_code, Model model, HttpSession httpSession
			) {

		log.debug("BCODE :" + b_code);
	
		BookDTO bookDTO = bService.findByCode(b_code);
		model.addAttribute("bookDTO", bookDTO);
		return "insert";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BookDTO bookDTO, Model model) {

		int ret = bService.update(bookDTO);

		return "redirect:/list";
	}
}
