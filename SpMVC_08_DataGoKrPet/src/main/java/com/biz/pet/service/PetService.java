package com.biz.pet.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.pet.config.DataGoConfig;
import com.biz.pet.domain.GoPetVO;
import com.biz.pet.domain.petrest.RestVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PetService {

	private final String go_pet_url = "http://openapi.jeonju.go.kr/rest/dongmulhospitalservice";

	public String getQueryHeader() {

		String queryString = go_pet_url;
		queryString += "/getDongMulHospital";

		queryString += "?ServiceKey=" + DataGoConfig.DATA_GO_AUTH;

		queryString += "&pageNo=1";
		queryString += "&numOfRows=100";

		return queryString;
	}

	public List<GoPetVO> getRestVOList(String s_cat, String s_text) {

		String queryString = this.getQueryHeader();

		try {
			if (s_cat.equalsIgnoreCase("ADDR")) {
				queryString += "&address=" + URLEncoder.encode(s_text, "UTF-8");
			} else {
				queryString += "&dongName=" + URLEncoder.encode(s_text, "UTF-8");
			}

		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// HttpRequest Header 설정하기
		HttpHeaders header = new HttpHeaders();

		header.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));

		// header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));

		HttpEntity<String> entity = new HttpEntity<String>("parameters", header);

		// Spring 3.2에서 도입된 새로운 httpConnection 추상화된 객체
		RestTemplate restTemp = new RestTemplate();

		URI restURI = null;
		ResponseEntity<RestVO> result = null;
		try {
			restURI = new URI(queryString);
			result = restTemp.exchange(restURI, HttpMethod.GET, entity, RestVO.class);
			RestVO resertVO = (RestVO) result.getBody();

			List<GoPetVO> goPetList = resertVO.body.data.list;
			return goPetList;

		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

//	public List<GoPetVO> getData(String s_text) {
//
//		String queryString = this.getRestString(s_text);
//		JsonElement jElement = JsonParser.parseString(queryString);
//		JsonObject oBody = (JsonObject) jElement.getAsJsonObject().get("body");
//		
//		JsonArray oList = null;
//		List<GoPetVO> petList = null;
//		JsonObject oData = null;
//		Gson gson = new Gson();
//
//		try {
//			oData = (JsonObject) oBody.getAsJsonObject().get("data");
//			oList = (JsonArray) oData.getAsJsonObject().get("list");
//
//			TypeToken<List<GoPetVO>> typeListToken = new TypeToken<List<GoPetVO>>() {
//
//			};
//			petList = gson.fromJson(oList, typeListToken.getType());
//			return petList;
//		} catch (ClassCastException e) {
//			log.debug("데이터가 1개 뿐임");
//			JsonObject petObj = (JsonObject) oData.getAsJsonObject().get("list");
//			TypeToken<GoPetVO> typeToken = new TypeToken<GoPetVO>() {
//			};
//			petList = new ArrayList<GoPetVO>();
//			petList.add(gson.fromJson(petObj, typeToken.getType()));
//			return petList;
//		}
//			
//
//	}
}
