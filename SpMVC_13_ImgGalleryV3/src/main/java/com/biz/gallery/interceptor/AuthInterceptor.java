package com.biz.gallery.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

/*
 * req를 가로채기를 실시
 */
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

	/*
	 * Dispatcher에서 Controller로 가는 도중 가로채기를 수행할 method
	 */
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String urlPath = request.getRequestURL().toString();
		String uriPath = request.getRequestURI().toString();
		
		String msg = String.format("URL : %s, \nURI : %s",urlPath,uriPath);
		
		// login 정보 확인
		// 1 res로부터 session ID 추출
		HttpSession httpSession = request.getSession();
		//Member Session을 확인하기 위해서 Attribute를 추출해서
		// Object 객체(sessionObj)에 담기
		Object sessionObj = httpSession.getAttribute("MEMBER");
		//Object 객체가 null 확인
		// null이면 member Session 객체가 없다
		// 없으면 login이 되어 있지 않다
		if(sessionObj == null) {
			//로그인 화면(form)으로 redirect를 수행하여
			// login을 하도록 유도
			response.sendRedirect(request.getContextPath()+"/member/login");
			
			// 현재로그인 안되어 있으므로 dispatcher에게
			// 더이상 다른일을 수행하지마라
			return false;
		}
		
		
		log.debug(msg);

		log.debug("나는 인터셉터");
		//return true;
		// controller에게 전달
		return super.preHandle(request, response, handler);
	}

}
