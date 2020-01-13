package com.biz.memo.domain;

import com.biz.memo.domain.MemoDTO.MemoDTOBuilder;

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
public class CatVO {

	private String catName;
	private String catValue;
}
