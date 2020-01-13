# 프로젝트 : 학생정보

## base-package : com.biz.student
## 패턴 : SpringMVC 패턴

* pom.xml의 dependency 수정
spring version 5.1.11 변경
lombok 추가
log 변경 logback 설정

* pom.xml의 java-version 수정
1.6 -> 1.8 변경

* web.xml에 한글 encording filter 설정
* servlet-context.xml 수정
compornent-scan의 base-package com.biz.sudent.controller로 변경

* Homecontroller.java 클래스파일을 com.biz.student.controller로 이동

* home.jsp 상단부분 page 설정