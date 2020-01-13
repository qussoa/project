package com.biz.memo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.ScriptAssert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@ScriptAssert(lang="javascript", script = "(_this.u_password == _this.re_password)",
reportOn = "re_password", message = "비밀번호와 확인비밀번호가 다름")
public class UserDTO {
	/*
	 * @Email : email 형식 검사
	 * @NotBlank : 공백검사
	 * @NotNull : null이 아닐경우만 정상
	 * @Null : null일 경우만 정상
	 * @Max(x),@Minx(X) : 숫자의 최대값 최소값 제한
	 * @Size(min=x, max=x: 문자일경우)
	 * @DecimalMax(x) : x값 이하의 십진수
	 * @DecimalMin(x) : x값 이상의 십진수
	 * @Digtis(integer = x) : x자리수 이하의 정수
	 * @Digtis(integer = x, fraction = y) : x자리수 이하의 정수이면서 y자리 이하의 소수점 자릿수 
	 */
	
	@Email(message = "@email.com")
	private String u_id;
	private String u_password;
	
	private String re_password;
	private String u_name;
	@NotBlank(message = "nickname is empty")
	private String u_nick;
	private String u_grade;
	// 정규형 표현식
	@Pattern(regexp = "\\d{1,15}",message = "1~15자리까지 숫자만 가능")
	private String u_tel;
	
	/*
	 * u_id varchar2(125 byte) 
	 * u_nick nvarchar2(125 char) 
	 * u_name nvarchar2(125 char)
	 * u_password nvarchar2(125 char) 
	 * u_tel nvarchar2(20 char) 
	 * u_grade nvarchar2(5
	 * char)
	 */
}
