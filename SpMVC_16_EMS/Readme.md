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