package com.biz.gdata.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.gdata.config.DataGoConfig;
import com.biz.gdata.domain.AreaBaseDTO;
import com.biz.gdata.domain.CityVO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

@Service
public class TourAppService {

	@Autowired
	TourGetService tgService;

	private String getHeaderQuery(String servName) throws UnsupportedEncodingException {
		String queryString = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/" + servName;

		queryString += "?ServiceKey=" + DataGoConfig.goDataAuth;
		queryString += "&MobileApp=" + URLEncoder.encode(DataGoConfig.MY_APP_NAME, "UTF-8");
		queryString += "&_type=json";
		queryString += "&MobileOS=ETC";

		queryString += String.format("&numOfRows=%d", 20);
		queryString += String.format("&pageNo=%d", 1);

		return queryString;
	}

	public String getAreaQuery() throws UnsupportedEncodingException {
		String queryString = this.getHeaderQuery("areaCode");
		return queryString;

	}
	
	public String getAreaQuery(String cityCode) throws UnsupportedEncodingException {
		String queryString = this.getHeaderQuery("areaCode");
		queryString += "&areaCode=" + cityCode;
		return queryString;

	}
	//Controller에서 호출	
	// city 코드가 없이 실행되는 코드
	// 시도 리스트를 추출
	public List<CityVO> getAreaData() throws JsonSyntaxException, IOException {
		return this.getAreaData(null);
	}
	
	//Controller에서 호출
	// 시도 리스트를 선택했을때 호출
	//city 코드가 있으면
	// 시군구 리스트를 추출
	public List<CityVO> getAreaData(String cityCode) throws JsonSyntaxException, IOException {

		String resString = "";
		if (cityCode == null) {
			resString = tgService.getDataString(this.getAreaQuery());
		} else {
			resString = tgService.getDataString(this.getAreaQuery(cityCode));
		}

		// JSONParser jParer = new JSONParser();
		JsonElement jElement = JsonParser.parseString(resString);

		JsonObject oRes = (JsonObject) jElement.getAsJsonObject().get("response");
		JsonObject oBody = (JsonObject) oRes.get("body");
		JsonObject oItems = (JsonObject) oBody.get("items");
		JsonArray oItemList = (JsonArray) oItems.get("item");

		TypeToken<List<CityVO>> cityToken = new TypeToken<List<CityVO>>() {
		};

		Gson gson = new Gson();
		List<CityVO> cityList = gson.fromJson(oItemList, cityToken.getType());

		return cityList;
	}
	public String getAreaBaseQuery(String cityCode) throws UnsupportedEncodingException {
		return this.getAreaBaseQuery(cityCode, null);
	}
	
	// 지역의 관광정보를 가져오기 위한 method
	public String getAreaBaseQuery(String cityCode, String sigun) throws UnsupportedEncodingException {
		
		String queryString = this.getHeaderQuery("areaBasedList");

		queryString += "&arrange=A";
		queryString += "&contentTypeId=15";
		queryString += String.format("&areaCode=%s", cityCode);
		queryString += "&listYN=Y";

		if(sigun != null) {
			queryString += "&sigunguCode=" +sigun;

		}
		return queryString;

	}

	public List<AreaBaseDTO> getAreaBaseListData(String cityCode, String sigun) throws JsonSyntaxException, IOException {

		String resString = tgService.getDataString(this.getAreaBaseQuery(cityCode,sigun));

		JsonElement jElement = JsonParser.parseString(resString);

		JsonObject oRes = (JsonObject) jElement.getAsJsonObject().get("response");
		JsonObject oBody = (JsonObject) oRes.get("body");
		JsonObject oItems = (JsonObject) oBody.get("items");
		JsonArray oItemList = (JsonArray) oItems.get("item");

		TypeToken<List<AreaBaseDTO>> cityToken = new TypeToken<List<AreaBaseDTO>>() {
		};

		Gson gson = new Gson();
		List<AreaBaseDTO> baseList = gson.fromJson(oItemList, cityToken.getType());

		return baseList;
	}
}
