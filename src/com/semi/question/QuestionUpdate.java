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


@WebServlet("/questionupdate.do")
public class QuestionUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		
		QuestionDAO dao = QuestionDAO.getInstance();
		QuestionDTO dto = dao.getQuestionDeatail(q_no);
		
		HttpSession session = request.getSession();
		session.setAttribute("UDDTO", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("questionUpdate.jsp");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String q_title = request.getParameter("q_title");
		String q_content = request.getParameter("q_content");
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		
		QuestionDAO  dao = QuestionDAO.getInstance();
		QuestionDTO dto = new QuestionDTO();
		dto.setQ_title(q_title);
		dto.setQ_content(q_content);
		dto.setQ_no(q_no);
		
		dao.updateQuestion(dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("questionlist.do");
		rd.forward(request, response);
		
		
	}

}
