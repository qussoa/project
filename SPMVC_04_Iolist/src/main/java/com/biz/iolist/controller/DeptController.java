package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biz.iolist.domain.DeptDTO;
import com.biz.iolist.service.DeptService;

@RequestMapping(value = "/dept")
@Controller
public class DeptController {

	@Autowired
	DeptService dService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {

		/*
		 * Model(ui.model) class와 같은 역할을 수행하는 string class 사용법이 조금 다른 형식 여기에는 view와 객체를
		 * 동시에 담아서 Dispatcher에게 객체를 return 해주는 형식으로 사용
		 */
		ModelAndView mView = new ModelAndView();

		List<DeptDTO> deptList = dService.getAllList();
		// return "/dept/list" 와같은 역할
		mView.setViewName("/dept/list");

		// model.addAtribute("DEPTLIST",deptList)와같은 역할
		mView.addObject("DEPTLIST", deptList);
		// return String 이 아닌 return mView
		return mView;
	}

}
