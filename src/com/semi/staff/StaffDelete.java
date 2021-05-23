package com.semi.staff;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.dao.StaffDAO;

@WebServlet("/staffdelete")
public class StaffDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sf_no=Integer.parseInt(request.getParameter("sf_no"));
		StaffDAO dao=StaffDAO.getInstance();
		dao.deleteStaff(sf_no);
		
		RequestDispatcher rd=request.getRequestDispatcher("stafflist");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int sf_no=Integer.parseInt(request.getParameter("sf_no"));
		StaffDAO dao=StaffDAO.getInstance();
		dao.deleteStaff(sf_no);
		
		RequestDispatcher rd=request.getRequestDispatcher("stafflist");
		rd.forward(request, response);
	}

}
