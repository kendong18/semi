package com.semi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnDAO {
	
	private String _driver = "oracle.jdbc.driver.OracleDriver";
	private String _url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String _user = "semi", _password = "1234";
	
	private static ConnDAO instance = null;
	
	private ConnDAO() {
	}
	
	public static ConnDAO getInstance() {
		if(instance==null) {
			instance = new ConnDAO();
		}
		return instance;
	}
	
	public Connection getConnection(){
		Connection conn = null;

		try {
			Class.forName(_driver);
			conn = DriverManager.getConnection(_url, _user, _password);
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 오류 : " + e.getMessage());
		}catch (SQLException e) {
			System.out.println("conn 오류 : " + e.getMessage());
		}
		return conn;
	}
	
	public void freeClose(Connection c, PreparedStatement p, ResultSet r) {
		try {
			if (r != null)
				r.close();
			if (p != null)
				p.close();
			freeClose(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void freeClose(Connection c, Statement s, ResultSet r) {
		try {
			if (r != null)
				r.close();
			if (s != null)
				s.close();
			freeClose(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void freeClose(Connection c, PreparedStatement p) {
		try {
			if (p != null)
				p.close();
			freeClose(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void freeClose(Connection c, Statement s) {
		try {
			if (s != null)
				s.close();
			freeClose(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void freeClose(Connection c) {
		try {
			if (c != null)
				c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
