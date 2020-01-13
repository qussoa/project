package com.biz.todo.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("todoDTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class ToDoList {

	private long td_seq;			//	number
	private String td_date;		//	varchar2(10 byte)
	private String td_time;		//	varchar2(8 byte)
	private String td_subject;	//	nvarchar2(125 char)
	private String td_text;		//	nvarchar2(1000 char)
	private String td_flag;		//	varchar2(1 byte)
	private String td_complete;	//	varchar2(1 byte)
	private String td_alarm;		//	varchar2(1 byte)
}
