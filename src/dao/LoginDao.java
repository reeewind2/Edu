package dao;
import java.sql.*;
import jdbc.*;
import java.util.*;
public class LoginDao {
	/*
		 1. �����ϴ� ���� �����ͺ��̽��� �ʿ��� ����(����̹��ε�, ���ؼ��� �޾ƿ´�)
	 */
	public Connection 	con;
	public WebDB			db;
	public LoginDao() {
		db = new WebDB();
		con = db.getCON();
	}
	
	/*
	 	 2. �ʿ��� ���� ����� ������ �Լ��� �����Ѵ�. (�� �Լ��� �������� ���� �� �ִ�.)
	 	 
	 	      1) �α��� Ȯ�� ���� ����
	 */
	
	public HashMap isMember(String id, String pw) {
		// �� �� �Լ����� ���̵�� ����� �˷��ָ� �� ȸ���� ������ �˷��� �Լ��� �����.
		PreparedStatement		pstmt = null;
		ResultSet					rs = null;
		HashMap					map = new HashMap();
		String sql = " SELECT * FROM Member WHERE m_ID = ? AND m_Password = ?";
		
		try {
			pstmt = db.getPSTMT(con, sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			// �� ȸ���� ������ HashMap�� �־ �˷��ش�.
			// 1. ���̵�, �Ǹ�, �г���
			if(rs.next()){
				map.put("ID", rs.getString("m_ID"));
				map.put("NAME", rs.getString("m_Name"));
				map.put("NICK", rs.getString("m_Nick"));
			}
		} catch (Exception e) {
			
		}
		finally {
			db.close(rs);
			db.close(pstmt);
		}
		return map;
		
	}
	
	/*
	 	 ���������� ��� �ڿ��� �ݾ��ִ� �Լ��� �����Ѵ�.
	 */
	
	public void close() {
		db.close(con);
	}
	
}