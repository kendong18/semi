package com.semi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.NoticeDAO;
import com.semi.dto.NoticeDTO;


@WebServlet("/noticewrite.do")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		Date time = new Date();
		String n_date= format.format(time);
		
		
		String n_title = request.getParameter("n_title");
		String n_content = request.getParameter("n_content");
		
		
		NoticeDTO dto = new NoticeDTO();
		dto.setN_content(n_content);
		dto.setN_date(n_date);
		dto.setN_title(n_title);
		
		NoticeDAO dao = NoticeDAO.getInstance();
		
		boolean flag = dao.insertNotice(dto);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("noticeList.do");
		if(flag) {
			
			rd.forward(request, response);
		}else {
			
			rd.forward(request, response);
		}
		
	}

}
