package com.biz.ems;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
/*
 * @Entity : jpa import = javax.persistence.Entity
 *  - jap interface에 정의된 속성 지정
 *  - Entity 물리적 table과 연동되도록 준비 ->  JPA에게 알림
 *  - 속성 중 다음 항목이 지정되어 있으면
 *  - <prop key="hibernate.hbm2ddl.auto">create</prop>
 *   Entity에 지정된 속성에 따라 table을 생성하라 
 *   create value : drop & create
 *   지정하지 않으면 기본값 create
 *   update로 지정하면 table이 없으면 생성하고 만약 물리적 table과 구조과 다르면
 *   오류가 발생한다 
 *   
 *   ※ 주의 : hib.hbm2ddl.auto 속성을 지정하지 않으면
 *   		  기본값으로 create가 지정되어 기존의 테이블을 
 *   		  drop한 후 재 작성해 버린다
 *   none : 기본값, 아무일도 하지 않는다
 *   create-only : table을 새로 생성
 *   drop : 삭제 
 *   create : drop and create 
 *   create-drop : 시작할 때 drop and create를 하고 session이 끝나면 다시 drop
 *   
 *   validate : 검증만 하고 
 *   update : 스키마 갱신 없으면 만들고 있으면 validate(검증) 수행
 */
@Entity
@Table(name = "tbl_ems", schema = "emsDB")
public class EmailVO2 {

	// 보내는 Email
	// 받는 Email
	// 보내는 사람
	// 받는 사람
	// 제목
	// 내용
	// 작성일자
	// 작성시각

	/*
	 * 필드 변수에 @Id, Column 속성을 지정하면 
	 *  - table의 칼럼으로 생성
	 *  - @Id primary key로 생성 
	 *  - @GeneratedValue(auto)로 지정하면
	 *    auto_increment를 수행하여 insert할 때 자동 값 채우기
	 *    
	 *    table의 칼럼명은 ems_seq로 지정하고
	 *    vo 클래스의 필드변수는 emsSeq
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ems_seq")
	private long emsSeq;

	/*
	 *  @Column() 지정하는 속성
	 *  nullable : not null과 연관
	 *  nullable = false : not null 설정
	 *  nullable = true : default null 설정
	 *  length : colunm의 길이  지정하지 않으면 DB기본 값 255 설정
	 *  칼럼을 생성할 때 필드 변수에 이름과 같이 설정
	 */
	
	@Column(name= "from_email", nullable = false,length = 20)
	private String fromEmail;
	
	/*
	 * @Column(name="to_email") 
	 * 필드변수와 칼럼의 이름을 달리 설정하고자 할 때 
	 */
	
	@Column(name = "to_email", nullable = false)
	private String to_email;
	
	/*
	 * @Cloumn(columnDefinition =""
	 *  칼럼의 타입을 DB에 고유한 Type으로 강제 적용
	 */
	@Column(name = "from_name", nullable = true, columnDefinition = "nVARCHAR(20)")
	private String fromName;
	
	@Column(nullable = true, columnDefinition = "nVARCHAR(20)")
	private String to_name;
	
	@Column(nullable = false, columnDefinition = "nVARCHAR(100)")
	private String subject;
	
	@Column(nullable = true, columnDefinition = "nVARCHAR(1000)")
	private String content;
	
	@Column(name="send_date",nullable = true)
	private String sendDate;
	
	@Column(name="send_time",nullable = false)
	private String sendTime;

}
