# EMS project
* Email management System Project V1 
* 2020-01-20

## JPA-Hibernate, mySQL 연동 Project

	<bean id="emsHiber"
		class="org.apache.commons.dbcp2.BasicDataSource">
		<property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
		<property name="url" value="jdbc:mysql://127.0.0.1:3306/emsDB?serverTimezone=Asia/seoul" />
		<property name="username" value="ems" />
		<property name="password" value="ems" />
	</bean>
	
* driverClassName : com.mysql.cj.jdbc.Driver을 사용
* url : 기본 연결 주소에 쿼리 값을 추가 serverTimezone=Asia/seoul 설정
* 5.x : SSL 연결을 하지 않는 &useSSL=false 옵션을 사용
* 8.x : &useSSL=false 옵션 오류 발생 추가 x

### naver ID로 로그인 구현
1. 네이버에게 login 창을 열어 보내달라 요청
	- 서버에서 state라는 특별한 key를 생성하고 그 값을 같이 보내야 한다
2. 네이버는 login 창을 우리에게 다시 redirect
3. 네이버가 보내준 login 창에 로그인을 수행하고 정상 로그인이 되면
4. OAuth20 규격의 token(버스표)를 보내주는데 이 토큰 이용 네이버의 정보를 