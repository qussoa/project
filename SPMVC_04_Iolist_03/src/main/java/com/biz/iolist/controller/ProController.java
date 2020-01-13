package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biz.iolist.domain.DeptDTO;
import com.biz.iolist.domain.ProductDTO;
import com.biz.iolist.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/pro")
@Controller
public class ProController {

	@Autowired
	ProductService pService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView mView = new ModelAndView();

		List<ProductDTO> proList = pService.getAllList();
		mView.setViewName("/pro/list");

		mView.addObject("PROLIST", proList);
		return mView;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String input(Model model) {

		return "pro/input";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String input(ProductDTO dto, Model model) {

		log.debug("상품정보" + dto.toString());
		int ret = pService.insert(dto);

		return "redirect:/pro/list";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(String p_code, Model model) {
		log.debug("상품코드 : " + p_code);
		ProductDTO dto = pService.findByPCode(p_code);
		model.addAttribute("PRODUCT_DTO", dto);
		return null;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id, Model model) {

		int let = pService.delete(id);

		return "redirect:/pro/list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model model) {

		ProductDTO dto = pService.findByPCode(id);
		model.addAttribute("PI", dto);
		return "pro/input";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(ProductDTO dto, Model model) {
		int ret = pService.update(dto);

		return "redirect:/pro/list";
	}
}
