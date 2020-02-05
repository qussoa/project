package com.biz.bbs.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("cmmVO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentVO {
	
	private long cmt_id;	//bigint(20)
	private long cmt_p_id;	//	bigint(20)
	private String cmt_writer;	//	varchar(20)
	private String cmt_date;	//	varchar(10)
	private String cmt_time;	//	varchar(10)
	private String cmt_text;	//	varchar(400)
}
