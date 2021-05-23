package com.semi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.semi.dto.MemberDTO;

public class MemberDAO {
	
	public static MemberDAO instance = null;
	private ConnDAO pool;
	
	public MemberDAO() {
		pool = ConnDAO.getInstance();
	}
	public static MemberDAO getInstance()  {
		if(instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public int userCheck(String co_id, String co_pwd) {
		// 아이디 , 비밀번호 확인 결과값 (-1 : 아이디 오류, 0 : 비밀번호, 1 : 성공)
		int result = -1;   
		
		String query="select co_pwd from company_tbl where co_id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = pool.getConnection();
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, co_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("co_pwd") != null && rs.getString("co_pwd").equals(co_pwd)) {
					result=1;	// 아이디, 비밀번호 모두 맞을 경우
				}else {
					result=0;   // 아이디만 맞을 경우
				}
				
			}else {
				result=-1;    // 아이디가 틀릴 경우
			}
			
		}catch(SQLException e) {
			System.out.println("userCheck() 에러 " + e.getMessage());
		}finally {
			try {
				if(rs != null) { rs.close(); }
				if(pstmt != null) { pstmt.close(); }
				if(con != null) { con.close(); }
			}catch(SQLException e) {
				System.out.println("userCheck() close 에러 " + e.getMessage());
			}
		}

		return result;
	}

	public MemberDTO getMember(String co_id) {
		MemberDTO dto = null;
		
		String query="select * from company_tbl where co_id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = pool.getConnection();
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, co_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto=new MemberDTO();
				dto.setCo_id(rs.getString("co_id"));
				dto.setCo_pwd(rs.getString("co_pwd"));
				dto.setCo_name(rs.getString("co_name"));
				dto.setCo_num(rs.getString("co_num"));
				dto.setCo_ceo(rs.getString("co_ceo"));
				dto.setCo_add(rs.getString("co_add"));
				dto.setCo_tel(rs.getString("co_tel"));
			}
			
		}catch(SQLException e) {
			System.out.println("getMember() 에러 " + e.getMessage());
		}finally {
			try {
				if(rs!=null) { rs.close(); }
				if(pstmt!=null) { pstmt.close(); }
				if(con!=null) { con.close(); }
			}catch(SQLException e) {
				System.out.println("getMember() close 에러 " + e.getMessage());
			}
		}
		
		return dto;
	}

	public int confirmID(String co_id) {
		int result = -1;  // 아이디 검색 결과 (아이디 존재 : 1 / 존재하지 않으면 -1)
		
		String query="select co_id from company_tbl where co_id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con = pool.getConnection();
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, co_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				result=1;
			}else {
				result=-1;
			}
			
		}catch(SQLException e) {
			System.out.println("confirmID() 에러  " +e.getMessage());
		}finally {
			try {
				if(rs != null) { rs.close();}
				if(pstmt != null) { pstmt.close();}
				if(con != null) { con.close();}
			}catch(SQLException e) {
				System.out.println("confirmID() close 에러 " +e.getMessage());
			}
		}

		return result;
	}

	public int insertMember(MemberDTO dto) {
		int result = -1;
		
		String query="insert into company_tbl values (?, ?, ?, ?, ?, ?, ?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con = pool.getConnection();
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, dto.getCo_id());
			pstmt.setString(2, dto.getCo_pwd());
			pstmt.setString(3, dto.getCo_name());
			pstmt.setString(4, dto.getCo_num());
			pstmt.setString(5, dto.getCo_ceo());
			pstmt.setString(6, dto.getCo_add());
			pstmt.setString(7, dto.getCo_tel());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("insertMember() 에러 " + e.getMessage());
		}finally {
			try {
				if(pstmt != null) { pstmt.close(); }
				if(con != null) { con.close(); }
			}catch(SQLException e) {
				System.out.println("insertMember() close 에러 " + e.getMessage());
			}
		}

		return result;
	}

	public int updateMember(MemberDTO dto) {
		int result = -1;
		
		String query="update company_tbl set co_pwd=?, co_name=?, co_num=?, co_ceo=?, co_add=?, co_tel=? where co_id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con = pool.getConnection();
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, dto.getCo_pwd());
			pstmt.setString(2, dto.getCo_name());
			pstmt.setString(3, dto.getCo_num());
			pstmt.setString(4, dto.getCo_ceo());
			pstmt.setString(5, dto.getCo_add());
			pstmt.setString(6, dto.getCo_tel());
			pstmt.setString(7, dto.getCo_id());
			
			result=pstmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("updateMember() 에러 " +e.getMessage());
		}finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(con != null) {con.close();}
			}catch (SQLException e) {
				System.out.println("updateMember() close 에러" +e.getMessage());
			}
		}

		return result;
	}

	public int deleteMember(String co_id) {
		int result = -1;
		
		String query="delete from company_tbl where co_id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		
		
		try {
			con = pool.getConnection();
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, co_id);
			result= pstmt.executeUpdate();
			
			
			
		}catch(SQLException e) {
			System.out.println("deleteMember() 에러  " +e.getMessage());
		}finally {
			try {
				
				if(pstmt != null) { pstmt.close();}
				if(con != null) { con.close();}
			}catch(SQLException e) {
				System.out.println("deleteMember() close 에러 " +e.getMessage());
			}
		}

		return result;
	}
	
}
