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

@WebServlet("/questioncontent.do")
public class QuestionComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String q_comment = request.getParameter("q_comment");
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		
		QuestionDTO dto = new QuestionDTO();
		dto.setQ_comment(q_comment);
		dto.setQ_no(q_no);
		
		
		QuestionDAO dao = QuestionDAO.getInstance();
		dao.commentQuestion(dto);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("questionlist.do");
		rd.forward(request, response);
		
	}

}
