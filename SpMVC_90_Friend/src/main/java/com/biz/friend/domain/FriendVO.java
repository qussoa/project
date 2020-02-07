package com.biz.friend.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Alias("friendVO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class FriendVO {
	
	private long fr_num; //bigint not null primary key,
	private String fr_name; // VARCHAR(10) NOT NULL,
	private String fr_tel; // VARCHAR(20) NOT NULL,
	private String fr_addr; // VARCHAR(255) NOT NULL,
	private String fr_hob; // VARCHAR(100),
	private String fr_rel; // VARCHAR(20)
	
}
