package com.semi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.NoticeDAO;
import com.semi.dto.NoticeDTO;


@WebServlet("/noticeupdate.do")
public class NoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int n_no = Integer.parseInt(request.getParameter("n_no"));
		String n_title = request.getParameter("n_title");
		String n_content = request.getParameter("n_content");
		
		NoticeDAO dao = NoticeDAO.getInstance();
		
		NoticeDTO dto = new NoticeDTO();
		
		dto.setN_content(n_content);
		dto.setN_no(n_no);
		dto.setN_title(n_title);
		
		dao.noticeUpdate(dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("noticeList.do");
		rd.forward(request, response);
	}

}
