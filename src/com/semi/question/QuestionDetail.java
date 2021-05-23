package com.semi.question;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.QuestionDAO;
import com.semi.dto.QuestionDTO;


@WebServlet("/questiondetail.do")
public class QuestionDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		QuestionDAO dao = QuestionDAO.getInstance();
		QuestionDTO dto = dao.getQuestionDeatail(q_no);
		
		HttpSession session = request.getSession();
		session.setAttribute("QDDTO", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("questionDetail.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		QuestionDAO dao = QuestionDAO.getInstance();
		QuestionDTO dto = dao.getQuestionDeatail(q_no);
		
		HttpSession session = request.getSession();
		session.setAttribute("QDDTO", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("questionDetail.jsp");
		rd.forward(request, response);
		
	}

}
