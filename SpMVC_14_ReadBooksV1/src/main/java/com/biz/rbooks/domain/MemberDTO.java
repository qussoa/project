package com.biz.rbooks.domain;

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
public class MemberDTO {
	
	private String m_id;			//  nvarchar2(20 char)
	private String m_password;		//	nvarchar2(125 char)
	private String m_login_date;	//	nvarchar2(125 char)
	private String m_rem;			//	nvarchar2(125 char)
}
