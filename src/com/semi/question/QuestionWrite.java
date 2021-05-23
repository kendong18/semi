package com.semi.question;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.QuestionDAO;
import com.semi.dto.QuestionDTO;


@WebServlet("/questionwrite.do")
public class QuestionWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String q_title = request.getParameter("q_title");
		String co_id = request.getParameter("co_id");
		String q_content = request.getParameter("q_content");
		
		
		QuestionDTO dto = new QuestionDTO();
		dto.setQ_title(q_title);
		dto.setCo_id(co_id);
		dto.setQ_content(q_content);
		
		
		QuestionDAO dao = QuestionDAO.getInstance();
		
		boolean flag = dao.insertQuestion(dto);
		RequestDispatcher rd = request.getRequestDispatcher("questionlist.do");
		if(flag) {
			rd.forward(request, response);
		}else {
			response.sendRedirect("questionErr.jsp");
		}
	}

}
