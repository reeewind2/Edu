package iedu.board;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.WebDB;

public class BoardInsert implements BoardMain {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		//	����
		//		�Ѿ�� �Ķ���͸� �޾Ƴ���.
		String		title = req.getParameter("title");
		String		body = req.getParameter("body");
		//	�ƽôٽ��� �۾��̴� disabled �Ǿ� �����Ƿ� �Ѿ���� ���Ѵ�.
		//	�׷��� ������ ���ǿ��� �˾Ƴ��� �Ѵ�.
		//	����		JSP�� session�� ���������� ���� session�� ����.
		//	�ذ�		session�� ���� ����ؾ� �Ѵ�.
		HttpSession	session = req.getSession();
		String		id = (String) session.getAttribute("ID");
		
		//		�� ������ �����ͺ��̽��� ����Ѵ�.
		//		���� �����ͺ��̽� ó���� dao Ŭ������ ���� ����ϴ� ���� �ǹ������� ��Ģ�̴�.
		//		�̹� �Խ����� ���ڵ����� �ϰڴ�.
		WebDB					db = null;
		Connection				con = null;
		PreparedStatement		pstmt = null;
		try {
			db = new WebDB();
			con = db.getCON();
			String	sql = "INSERT INTO ReBoard VALUES((SELECT NVL(MAX(rb_NO), 0) + 1 FROM ReBoard), ?, ?, ?, SYSDATE, 0, 'Y')";
			pstmt = db.getPSTMT(con, sql);
			pstmt.setString(1, title);
			pstmt.setString(2, id);
			pstmt.setString(3, body);
			pstmt.execute();
		}
		catch(Exception e) {
			System.out.println("�Խù� ��� ���� = " + e);
		}
		finally {
			db.close(pstmt);
			db.close(con);
		}
		//		������� �����Ƿ�...	�並 �����Ѵ�.
		return "/Board/BoardInsert.jsp";
	}

}
