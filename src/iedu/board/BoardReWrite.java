package iedu.board;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.WebDB;

/*
	���� ������ ������ �ϱ� ���ؼ� ���� ���� ��ӹ޾Ƽ� ������ ����޴�.
 */
public class BoardReWrite implements BoardMain{
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		// ����
		//		�Ѿ�� �Ķ���� �޴´�.
		String	strOriNO = req.getParameter("oriNO");
		int		oriNO = Integer.parseInt(strOriNO);
		String	body = req.getParameter("body");
		HttpSession session = req.getSession();
		String	writer = (String)	session.getAttribute("ID");
		//		�����ͺ��̽��� ����Ѵ�.
		WebDB		db = null;
		Connection	con = null;
		PreparedStatement pstmt = null;
		try {
			db = new WebDB();
			con = db.getCON();
			String	sql = "INSERT INTO ReReply VALUES((SELECT NVL(MAX(rr_NO),0) + 1 FROM ReReply), ?, ?, ?, SYSDATE, 'Y')";
			pstmt = db.getPSTMT(con, sql);
			pstmt.setInt(1, oriNO);
			pstmt.setString(2, writer);
			pstmt.setString(3, body);
			pstmt.execute();
			
		} catch (Exception e) {
			System.out.println("��� ��� ���� = " + e);
		}
		finally{
			db.close(pstmt);
			db.close(con);
		}
		//		�信�� ����� �����͸� �ݵ�� �����־�� �Ѵ�.
		req.setAttribute("ORINO", oriNO);
		//		�並 �����Ѵ�.
		
		return "/Board/BoardReWrite.jsp";
	}
}
