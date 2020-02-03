package com.biz.bbs.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BBsVO {

	private long bbs_id;	//BIGINT
	private String bbs_p_id;	//	BIGINT
	private String bbs_writer;	//	VARCHAR(50)
	private String bbs_date;	//	VARCHAR(10)
	private String bbs_time;	//	VARCHAR(10)
	private String bbs_subject;	//	VARCHAR(125)
	private String bbs_content;	//	varchar(1000)
	private int bbs_count;	//	INT

}
