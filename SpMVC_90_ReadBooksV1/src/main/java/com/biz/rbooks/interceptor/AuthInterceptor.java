package com.biz.rbooks.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String urlPath = request.getRequestURL().toString();
		String uriPath = request.getRequestURI().toString();

	//	String msg = String.format("URL : %s, \nURI : %s", urlPath, uriPath);

		HttpSession httpSession = request.getSession();

		Object sessionObj = httpSession.getAttribute("MEMBER");

		if (sessionObj == null) {

			response.sendRedirect(request.getContextPath() + "/member/login");

			return false;
		}

		return super.preHandle(request, response, handler);
	}
}
