package com.semi.question;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.QuestionDAO;
import com.semi.dto.QuestionDTO;


@WebServlet("/questionlist.do")
public class QuestionList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		QuestionDAO dao = QuestionDAO.getInstance();
		
		ArrayList<QuestionDTO> dto = dao.getQuestionList();
		
		HttpSession session = request.getSession();
		session.setAttribute("QDTO", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("question.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		QuestionDAO dao = QuestionDAO.getInstance();
		
		ArrayList<QuestionDTO> dto = dao.getQuestionList();
		
		HttpSession session = request.getSession();
		session.setAttribute("QDTO", dto);
		
		RequestDispatcher rd = request.getRequestDispatcher("question.jsp");
		rd.forward(request, response);
		
	}

}
