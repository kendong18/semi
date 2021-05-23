package com.semi.staff;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.semi.dao.StaffDAO;
import com.semi.dto.StaffDTO;

@WebServlet("/stafflist")
public class StaffList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StaffDAO dao=StaffDAO.getInstance();
		
		Vector<StaffDTO> dto=dao.getStaff();
		
		HttpSession session=request.getSession();
		session.setAttribute("DTO", dto);
		RequestDispatcher rd=request.getRequestDispatcher("staffList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		StaffDAO dao=StaffDAO.getInstance();
		
		Vector<StaffDTO> dto=dao.getStaff();
		
		HttpSession session=request.getSession();
		session.setAttribute("DTO", dto);
		RequestDispatcher rd=request.getRequestDispatcher("staffList.jsp");
		rd.forward(request, response);
	}

}
