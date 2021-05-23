package com.semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import com.semi.dto.NoticeDTO;

public class NoticeDAO {
	
	
	public static NoticeDAO instance = null;
	
	private ConnDAO pool;
	
	public NoticeDAO() {
		pool = ConnDAO.getInstance();
	}
	public static NoticeDAO getInstance()  {
		if(instance == null) {
			instance = new NoticeDAO();
		}
		return instance;
	}
	
	
	public boolean insertNotice(NoticeDTO nDTO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into notice_tbl (n_no, n_title, n_content, n_date) values (semi_seq.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nDTO.getN_title());
			pstmt.setString(2, nDTO.getN_content());
			pstmt.setString(3, nDTO.getN_date());
			if(pstmt.executeUpdate()==1) {
				flag = true;
			}
			
		}catch (Exception e) {
			System.out.println("insertNotice(NoticeDTO nDTO) 에러 : " + e.getMessage());
		}
		return flag;
	}
	
	public ArrayList<NoticeDTO> getNoticeList(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<NoticeDTO> alist = new ArrayList<NoticeDTO>();
		try {
			con = pool.getConnection();
			sql = "select * from notice_tbl order by n_no desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setN_no(rs.getInt(1));
				dto.setN_title(rs.getString(2));
				dto.setN_date(rs.getString(3));
				dto.setN_content(rs.getString(4));
				alist.add(dto);
			}
		}catch (Exception e) {
			System.out.println("ArrayList<NoticeDTO> getNoticeList() : 에러 : " + e.getMessage());
		}finally {
			pool.freeClose(con, stmt, rs);
		}
		return alist;
	}
	
	public Vector<NoticeDTO> getNotice(){
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<NoticeDTO> vlist = new Vector<NoticeDTO>();
		
		try {
			con = pool.getConnection();
			sql = "select * from notice_tbl order by n_no desc";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setN_no(rs.getInt(1));
				dto.setN_title(rs.getString(2));
				dto.setN_date(rs.getString(3));
				dto.setN_title(rs.getString(4));
				vlist.addElement(dto);
			}
		}catch (Exception e) {
			System.out.println("Vector<NoticeDTO> getNotice() 에러 : " + e.getMessage());
		}finally {
			pool.freeClose(con, stmt, rs);
		}
		return vlist;
	}
	
	public NoticeDTO getNoticeDetail(int n_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		ResultSet rs = null;
		NoticeDTO dto = new NoticeDTO();
		try {
			sql = "select * from notice_tbl where n_no=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, n_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setN_no(rs.getInt("n_no"));
				dto.setN_title(rs.getString("n_title"));
				dto.setN_content(rs.getString("n_content"));
				dto.setN_date(rs.getString("n_date"));
			}
		}catch (Exception e) {
			System.out.println("getNoticeDetail() 에러 : " + e.getMessage());
		}finally {
			pool.freeClose(con, pstmt, rs);
		}
		
		return dto;
	}
	
	public void noticeUpdate(NoticeDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		
		
		try {
			sql = "update notice_tbl set n_title=?, n_content=? where n_no=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getN_title());
			pstmt.setString(2, dto.getN_content());
			pstmt.setInt(3, dto.getN_no());
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("noticeUpdate(NoticeDTO dto) 에러 : " + e.getMessage());
		}finally {
			pool.freeClose(con, pstmt);
		}
	}
	
	public void noticeDelete(int n_no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		try {
			sql = "delete from notice_tbl where n_no=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, n_no);
			pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("noticeDelete(int n_no) 에러 : " + e.getMessage());
		}finally {
			pool.freeClose(con, pstmt);
		}
	}
}
