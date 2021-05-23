package com.semi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.NoticeDAO;
import com.semi.dto.NoticeDTO;


@WebServlet("/noticeList.do")
public class NoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeDAO dao = NoticeDAO.getInstance();
		
		ArrayList<NoticeDTO> dto = dao.getNoticeList();
		
		
		HttpSession session = request.getSession();
		session.setAttribute("DTO", dto);
		RequestDispatcher rd = request.getRequestDispatcher("notice.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		NoticeDAO dao = NoticeDAO.getInstance();
		
		ArrayList<NoticeDTO> dto = dao.getNoticeList();
		
		
		HttpSession session = request.getSession();
		session.setAttribute("DTO", dto);
		RequestDispatcher rd = request.getRequestDispatcher("notice.jsp");
		rd.forward(request, response);
		
	}

}
