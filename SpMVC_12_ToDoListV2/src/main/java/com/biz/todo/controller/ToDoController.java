package com.biz.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.todo.common.ToDoAnn;
import com.biz.todo.domain.ToDoList;
import com.biz.todo.service.ToDoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ToDoController {

	@Autowired
	@Qualifier("toServiceV3")
	ToDoService toService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {

		List<ToDoList> todoList = toService.selectAll();
		model.addAttribute("todoList", todoList);

		return "home";
	}

	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String insert(@ModelAttribute ToDoList todoList, Model model) {

		int ret = toService.insert(todoList);
		if (ret < 1) {
			model.addAttribute("INSERT_ERROR", "NOT_INSERT");
		}

		return "redirect:/list";
	}

	@RequestMapping(value = "complete", method = RequestMethod.GET)
	public String complete(@RequestParam("td_seq") String strSeq, @RequestParam("td_complete") String td_complete) {

		toService.complete(strSeq);

		return "redirect:/list";
	}

	@RequestMapping(value = "alarm", method = RequestMethod.GET)
	public String alarm(@RequestParam("td_seq") String strSeq, @RequestParam("td_alarm") String td_alarm) {

		toService.alarm(strSeq);

		return "redirect:/list";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("td_seq") String strSeq) {
		try {
			long td_seq = Long.valueOf(strSeq);
			toService.delete(td_seq);
		} catch (Exception e) {
			log.debug("삭제 오류 : ");
		}

		return "redirect:/list";
	}

	@RequestMapping(value = "update", method=RequestMethod.GET)
	public String update(@RequestParam("td_seq") String strSeq, Model model) {
		
		long td_seq = Long.valueOf(strSeq);
		ToDoList toDTO = toService.findBySeq(td_seq);
		
		model.addAttribute("todoDTO",toDTO);
		List<ToDoList> tdList = toService.selectAll();
		model.addAttribute("todoList",tdList);
		return "home";
	}
	
	@RequestMapping(value = "update", method=RequestMethod.POST)
	public String update(ToDoList tdList, Model model) {
		
		toService.update(tdList);
		
		return "redirect:/list";
	}
	
}
