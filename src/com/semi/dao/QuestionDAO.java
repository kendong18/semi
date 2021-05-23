package com.semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.semi.dto.QuestionDTO;

public class QuestionDAO {
	
	public static QuestionDAO instance = null;
	
	private ConnDAO pool;
	
	public QuestionDAO() {
		pool = ConnDAO.getInstance();
	}
	
	public static QuestionDAO getInstance() {
		if(instance==null) {
			instance = new QuestionDAO();
		}
		return instance;
	}
	
	
	public boolean insertQuestion(QuestionDTO qDTO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into question_tbl (q_no, q_title, co_id, q_content) values (q_seq.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, qDTO.getQ_title());
			pstmt.setString(2, qDTO.getCo_id());
			pstmt.setString(3, qDTO.getQ_content());
			
			if(pstmt.executeUpdate()==1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("insertQuestion 에러 : " + e.getMessage());
		} finally {
			pool.freeClose(con, pstmt);
		}
		return flag;
	}
	
	public ArrayList<QuestionDTO> getQuestionList(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<QuestionDTO> alist = new ArrayList<QuestionDTO>();
		try {
			con = pool.getConnection();
			sql = "select * from question_tbl order by q_no desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				QuestionDTO dto = new QuestionDTO();
				dto.setQ_no(rs.getInt(1));
				dto.setQ_title(rs.getString(2));
				dto.setCo_id(rs.getString(3));
				dto.setQ_content(rs.getString(4));
				dto.setQ_comment(rs.getString(5));
				
				alist.add(dto);
			}
		}catch (Exception e) {
			System.out.println("getQuestionList() 에러 : " + e.getMessage());
		}finally {
			pool.freeClose(con, stmt, rs);
		}
		return alist;
	}
	
	public QuestionDTO getQuestionDeatail(int q_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		QuestionDTO dto = new QuestionDTO();
		try {
			sql = "select * from question_tbl where q_no=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, q_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setQ_no(rs.getInt("q_no"));
				dto.setCo_id(rs.getString("co_id"));
				dto.setQ_title(rs.getString("q_title"));
				dto.setQ_content(rs.getString("q_content"));
				dto.setQ_comment(rs.getString("q_comment"));
				
			}
		}catch (Exception e) {
			System.out.println("getQuestionDeatail(int q_no) 에러 : " + e.getMessage());
		}finally {
			pool.freeClose(con, pstmt, rs);
		}
		return dto;
	}
	
	public void updateQuestion(QuestionDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			sql = "update question_tbl set q_title=?, q_content=? where q_no=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getQ_title());
			pstmt.setString(2, dto.getQ_content());
			pstmt.setInt(3, dto.getQ_no());
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("updateQuestion(QuestionDTO dto) 에러 : " + e.getMessage());
		}finally {
			pool.freeClose(con, pstmt);
		}
	}
	
	public void deleteQuestion(int q_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			sql = "delete from question_tbl where q_no=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, q_no);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("deleteQuestion(int q_no) 에러 : " + e.getMessage());
		}finally {
			pool.freeClose(con, pstmt);
		}
	}
	
	public void commentQuestion(QuestionDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			sql = "update question_tbl set q_comment=? where q_no=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getQ_comment());
			pstmt.setInt(2, dto.getQ_no());
			
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("contentQuestion(String q_content) 에러 : " + e.getMessage());
		}finally {
			pool.freeClose(con, pstmt);
		}
	}
	
}























