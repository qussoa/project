package com.biz.gdata.domain;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Json data를 변환하는 용도로 사용할 VO class
 * 변수 이름은 json data의 칼럼과 같도록 해야한다
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CityVO {

	private String code;
	private String name;
	
}
