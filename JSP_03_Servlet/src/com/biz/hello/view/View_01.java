package com.biz.hello.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View_01
 */
@WebServlet("/view/01")
public class View_01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 
     *  /view/01 : URI, java Web에서는 path라고 한다
     *  /view : view path, 01 view path router라고 한다
     */
    public View_01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		String strName = request.getParameter("strName");
		response.setStatus(404);
		PrintWriter wOut = response.getWriter();
		
		//httpCode response에 세팅하기
		wOut.println("나는 view_01입니다");
		
		/*
		 * httpCode
		 * server에서 webBrowser에게 데이터를 보내기 전에
		 * 현재 서버의 상태가 어떠한지 
		 * 숫자값으로 전송을 하여 네트웍에 성능을 높이는 용도로 사용한다
		 * 
		 * 2xx : 정상데이터를 추출중이니 대기
		 * 3xx : 이전상태와 유사, 동일하니 너에게 줄것이 없다
		 * 4xx : 요청사항이 잘 못 전달 됨
		 * 		404 : not found
		 * 		400 : query data를 request.getParamater()로 받았는데 문제발생
		 * 5xx : 서버 app이 작동되는 과정에서 Exception발생
		 */
		wOut.printf("나는 %s입니다", strName);
		wOut.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
