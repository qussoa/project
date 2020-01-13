package com.biz.memo.domain;

import com.biz.memo.domain.UserDTO.UserDTOBuilder;

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
public class UserHobbyDTO {
	private long uh_seq;//	number	not null	primary key,
	private String uh_id;//	varchar2(125)	not null,
	private String uh_code;//	varchar2(5)	not null	
}
