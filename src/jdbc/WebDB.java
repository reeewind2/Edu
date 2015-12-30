package jdbc;
/*
	�� Ŭ������ ���ſ� JDBC ������ �� �� ������� JDBCUtil Ŭ������ ���� ������ �� Ŭ�����̴�.
 */
import java.sql.*;

public class WebDB {
	/*
	 	1. ������ �Լ����� ����̹��� �ε��ϵ��� �Ѵ�.
	 */
	
	public WebDB() {

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(Exception e) {
			System.out.println("����̹� �ε� ����");
		}
	}
	
	/*
		2. ���ؼ��� ���ϴ� �Լ��� �����Ѵ�.
	 */
	
	public Connection getCON() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.49:1521:orcl", "scott", "tiger");
		} catch (Exception e) {
			System.out.println("���ؼ� ����" + e);
		}
		return con;
	}
	
	/*
	 	3. Statement�� ������ִ� �Լ��� �����Ѵ�.
	 */
	
	public Statement getSTMT(Connection con) {
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.println("������Ʈ��Ʈ ���� ����" + e);
		}
		return stmt;
	}
	
	/*
	 	4. PreparedStatement �� ������ִ� �Լ��� �����Ѵ�.
	 */
	
	public PreparedStatement getPSTMT(Connection con, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		} catch (Exception e) {
			System.out.println("PreparedStatement ���� ����" + e);
		}
		return pstmt;
	}
	/*
	 	5. �ݾ��ִ� �Լ��� �����Ѵ�.
	 */
	
	public void close(Object obj) {
		try {
			if(obj instanceof Connection) {
				Connection target = (Connection) obj;
				target.close();
			}
			else if(obj instanceof Statement) {
				Statement target = (Statement) obj;
				target.close();
			}
			else if(obj instanceof PreparedStatement) {
				((PreparedStatement)obj).close();
			}
			else if(obj instanceof ResultSet) {
				((ResultSet)obj).close();
			}
		} catch (Exception e) {
			System.out.println("Close ����" + e);
		}
	}
}