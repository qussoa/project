package com.biz.iolist.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;
import com.biz.iolist.service.IolistService;

@RequestMapping(value = "/iolist")
@Controller
public class IolistController {

	@Autowired
	IolistService iService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ioHome(Model model) {
		/*
		 * 아직 ciewAllList() method를 생성하지 않은 상태에서 viewAllList() 호출하여 할일을 먼저 정의한 것
		 * TDD(Test Driven Developer)
		 */
		List<IolistVO> iolist = iService.viewAllList();
		/*
		 * jsp view에서 사용할 변수 역할을 수행할 Attribute를 등록하는 절차이고 이때 이름 "IOLIST"를 대문자로 사용한는 이유
		 * 대소문자가 섞이면 문자 차이로 인한 오류가 발생하거나 값을 표시하지 못하는 일이 있는데 이를 방지하기 위함이다
		 */
		model.addAttribute("IOLIST", iolist);

		return "iolist/list";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String list(Model model) {

		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		String curDate = sd.format(date);

		IolistDTO dto = IolistDTO.builder()

				.io_date(curDate)

				.build();

		model.addAttribute("IO_DTO", dto);

		return "iolist/input";
	}

	// 입력 form에서 데이터를 입력하고 전송버튼을 클릭했을때 데이터를 수신할 method
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String list(Model model, IolistDTO dto) {

		int ret = iService.insert(dto);
		// insert(input) update delete POST를 수행한 후
		// list를 보여서 변경된 사항을 보이기
		return "redirect:/iolist/list";
	}

	/*
	 * tbl_iolist seq 칼럼은 숫자형인데 일단 eq 칼럼으로 조회를 하기위한 쿼리값인 id는 문자열로 받는다 혹시 id값이 전송되지
	 * 않아서 발생할 수 잇는 400 오류 방지
	 */
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view(String id, Model model) {

		long io_seq = 0;
		try {
			io_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}

		IolistVO vo = iService.findBySeq(io_seq);
		model.addAttribute("IO_DTO",vo);
		return "iolist/view";
	}
}
