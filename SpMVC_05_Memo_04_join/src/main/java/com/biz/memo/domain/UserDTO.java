package com.biz.memo.domain;

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
public class UserDTO {
	
	private String u_id;
	private String u_password;
	private String u_name;
	private String u_nick;
	private String u_grade;
	private String u_tel;
	//사용자의 취미가 중복 선택 가능 기능구현
	private String[] u_hobby;
	/*
	 * io_id VARCHAR2(125) NOT NULL PRIMARY KEY, 
	 * io_nick NVARCHAR2(125) , 
	 * io_name NVARCHAR2(125) NOT NULL, 
	 * io_password NVARCHAR2(125) NOT NULL , 
	 * io_tel NVARCHAR2(20) ,
	 * io_grade NVARCHAR2(5)
	 */
}
