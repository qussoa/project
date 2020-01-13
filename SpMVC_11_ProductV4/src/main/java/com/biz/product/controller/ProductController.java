package com.biz.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.product.domain.ProFileDTO;
import com.biz.product.domain.ProductDTO;
import com.biz.product.persistence.FileDao;
import com.biz.product.service.FileService;
import com.biz.product.service.ProductSerivce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {

	@Autowired
	ProductSerivce pService;

	@Autowired
	FileService fService;

	@RequestMapping(value = "plist", method = RequestMethod.GET, produces = "application/json;charset=UTF-8;")

	public String getPlist(Model model) {
		List<ProductDTO> proList = pService.selectAll();

		model.addAttribute("PLIST", proList);
		return "home";
	}

	@RequestMapping(value = "input", method = RequestMethod.POST)
	public String input(@ModelAttribute ProductDTO proDTO,

			@RequestParam("u_file") MultipartFile u_file, MultipartHttpServletRequest u_files) {

		for (MultipartFile f : u_files.getFiles("u_files")) {
			log.debug("파일 이름 : " + f.getOriginalFilename());
		}
		/*
		 * 대표이미지가 업로드 되었을때
		 * 
		 */

		try {
			String proFileImage = fService.fileUp(u_file);
			if (proFileImage != null) {
				if (proDTO.getP_file() != null) {
					fService.fileDelete(proDTO.getP_file());
				}
				proDTO.setP_file(proFileImage);
			}

		} catch (Exception e) {
			log.debug("대표이미지 업로드 오류 : " + e.getMessage());
		}

		List<ProFileDTO> upFileList = fService.filesUp(u_files);

		int ret = 0;
		if (proDTO.getP_code().isEmpty()) {
			log.debug("새로운 상품등록");

			ret = pService.insert(proDTO, upFileList);

		} else {
			log.debug("기존 상품변경");

			ret = pService.update(proDTO, upFileList);

		}

		return "redirect:/plist";
	}

	@RequestMapping(value = "proImgDelete", method = RequestMethod.GET)
	public String imgDelete(String p_code) {

		pService.proImgDelete(p_code);
		
		return "redirect:/plist";
	}

	@RequestMapping(value = "subImgDelete", method=RequestMethod.GET)
	public String subImgDelete(String file_seq) {
	
		
		pService.subImgDelete(file_seq);
		return "redirect:/plist";
	}
	
	@ResponseBody
	@RequestMapping(value = "getString", method = RequestMethod.GET,

			produces = "application/json;charset=UTF-8")
	public String getString(

			@RequestParam(value = "str",

					required = false,

					defaultValue = "없음")

			String myStr) {

		if (myStr.equals("없음")) {
			return "http://localhost:8080/product/getString?str=문자열 형식으로 보내세요";
		} else {
			return "보낸문자열은? : " + myStr;
		}
	}

	@ResponseBody
	@RequestMapping(value = "plist/name", method = RequestMethod.GET, produces = "application/json;charset=UTF-8;")

	public List<ProductDTO> getNames(String p_name) {
		List<ProductDTO> proList = pService.findByPNames(p_name);
		return proList;
	}

	@ResponseBody
	@RequestMapping(value = "pname", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8;")
	public String getPName(String p_code) {

		ProductDTO proDTO = pService.findByPCode(p_code);

		return "<h1>" + proDTO.getP_name() + "</h1>";

	}

	@ResponseBody
	@RequestMapping(value = "oprice", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String getOPrice(String p_code) {

		ProductDTO proDTO = pService.findByPCode(p_code);
		return proDTO.getP_oprice() + "";

	}

	@ResponseBody
	@RequestMapping(value = "iprice", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String getIPrice(String p_code) {

		ProductDTO proDTO = pService.findByPCode(p_code);
		return proDTO.getP_iprice() + "";
	}

}
