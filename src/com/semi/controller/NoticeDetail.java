package com.semi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.NoticeDAO;
import com.semi.dto.NoticeDTO;


@WebServlet("/noticedetail.do")
public class NoticeDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n_no = Integer.parseInt(request.getParameter("n_no"));
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeDTO dto = dao.getNoticeDetail(n_no);

		HttpSession session = request.getSession();
		session.setAttribute("DDTO", dto);

		RequestDispatcher rd = request.getRequestDispatcher("noticeDetail.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n_no = Integer.parseInt(request.getParameter("n_no"));
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeDTO dto = dao.getNoticeDetail(n_no);

		HttpSession session = request.getSession();
		session.setAttribute("UDTO", dto);

		RequestDispatcher rd = request.getRequestDispatcher("noticeUpdate.jsp");
		rd.forward(request, response);
	}

}
