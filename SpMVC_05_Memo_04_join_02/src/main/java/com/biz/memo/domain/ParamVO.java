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
public class ParamVO {

	private String BODY;
	private String LOGIN_MSG;
}
