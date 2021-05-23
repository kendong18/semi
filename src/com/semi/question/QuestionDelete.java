package com.semi.question;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.QuestionDAO;


@WebServlet("/questiondelete.do")
public class QuestionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		
		QuestionDAO dao = QuestionDAO.getInstance();
		dao.deleteQuestion(q_no);
		
		RequestDispatcher rd = request.getRequestDispatcher("questionlist.do");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
