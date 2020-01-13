package com.biz.naver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.naver.config.NaverConfig;
import com.biz.naver.domain.PageDTO;

import lombok.Builder.ObtainVia;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverServiceV2 {

	private final String naver_news_url = "https://openapi.naver.com/v1/search/news.json";
	private final String naver_book_url = "https://openapi.naver.com/v1/search/book.json";
	private final String naver_movie_url = "https://openapi.naver.com/v1/search/movie.json";

	@Autowired
	PageService pService;

	public PageDTO getPage(String cat, String search, long currentPageNo) throws IOException, ParseException {
		String totalQuery = this.queryNaver(cat, search);

		String totalString = this.getNaverString(totalQuery);
		JSONObject totalJObject = this.strToJson(totalString);

		
		
		String strTotal = totalJObject.get("total").toString();

		long totalCount = Long.valueOf(strTotal);
		
		if(totalCount > 1000) totalCount = 1000;
		
		PageDTO pageDTO = pService.makePagination(totalCount, currentPageNo);

		log.debug("전체개수 : " + totalCount);

		return pageDTO;
	}

	// 0.
	public JSONArray getNaver(String cat, String search, long currentPageNo) throws IOException, ParseException {

		PageDTO pageDTO = this.getPage(cat, search, currentPageNo);
		
		if(currentPageNo == 1) currentPageNo = 1;
		else currentPageNo = (currentPageNo-1) * pageDTO.getListPerPage() + 1 ;
		
		
		String queryString = this.queryNaver(cat, search, currentPageNo,pageDTO.getListPerPage());
		String resString = this.getNaverString(queryString);
		JSONObject resObject = this.strToJson(resString);
		JSONArray resArray = this.getArray(resObject, "items");

		return resArray;
	}

	// 1. cat, search, start, display 값을 매개변수로 받아서
	// start부터 display 갯수만큼 데이터를 가져오기 위해 queryString 생성
	public String queryNaver(String cat, String search, long start, long display) throws UnsupportedEncodingException {
		String queryString = URLEncoder.encode(search, "UTF-8");
		queryString = this.queryURL(cat) + "?query=" + queryString;

		queryString += "&start=" + start;
		queryString += "&display=" + display;

		return queryString;
	}

	public String queryNaver(String cat, String search) throws UnsupportedEncodingException {
		String queryString = URLEncoder.encode(search, "UTF-8");
		queryString = this.queryURL(cat) + "?query=" + queryString;
		return queryString;
	}

	// 2. queryNaver에서 생성한 queryString 문자열을 매개변수로 받아서
	// 네이버에게 전송하고 response된 문자열 리턴
	public String getNaverString(String queryString) throws IOException {

		URL url = new URL(queryString);
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		httpConn.setRequestProperty("X-Naver-Client-Id", NaverConfig.NaverClientID);
		httpConn.setRequestProperty("X-Naver-Client-Secret", NaverConfig.NaverClientSecret);
		int resCode = httpConn.getResponseCode();
		BufferedReader buffer;
		if (resCode == 200) {
			InputStreamReader is = new InputStreamReader(httpConn.getInputStream());
			buffer = new BufferedReader(is);
		} else {
			// 오류가 발생했을 시 오류 메세지를 errorStream을 통해서 받기
			InputStreamReader is = new InputStreamReader(httpConn.getErrorStream());
			buffer = new BufferedReader(is);
		}

		// String resString = "";
		StringBuffer resString = new StringBuffer();

		String reader = "";
		while (true) {
			reader = buffer.readLine();
			if (reader == null)
				break;
			resString.append(reader);
		}

		// debugging을 위한 코드
		if (resCode == 200) {
			return resString.toString();

		} else {
			log.debug("네이버오류" + resString.toString());
		}
		return null;
	}

	// 3. 네이버에서 response한 문자열을 통째로 JSON Object로 변환
	public JSONObject strToJson(String jsonString) throws ParseException {

		JSONParser jParser = new JSONParser();
		JSONObject jObject = (JSONObject) jParser.parse(jsonString);

		return jObject;
	}

	/*
	 * 4. JSONObject로부터 Naver의 items만 추출하여 JSONArray로 변환 naver로부터 받은 데이터에서 items 항목을
	 * 추출하여 실제 데이터들을 Array로 만들어준 method
	 */
	public JSONArray getArray(JSONObject jObject, String keystring) {
		return (JSONArray) jObject.get(keystring);
	}

	public String queryURL(String cat) {

		String queryURL = naver_news_url;
		if (cat.equalsIgnoreCase("NEWS")) {
			queryURL = naver_news_url;
		} else if (cat.equalsIgnoreCase("BOOK")) {
			queryURL = naver_book_url;
		} else if (cat.equalsIgnoreCase("MOVIE")) {
			queryURL = naver_movie_url;
		}

		return queryURL;
	}

}
