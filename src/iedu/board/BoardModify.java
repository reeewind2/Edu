package iedu.board;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.WebDB;

public class BoardModify implements BoardMain {
	
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		String strOriNO = req.getParameter("oriNO");
		String		title = req.getParameter("title");
		String		content = req.getParameter("content");
		int	oriNO = Integer.parseInt(strOriNO);
		String	body = req.getParameter("BODY");
		HttpSession	session = req.getSession();
		String 	Writer = (String)session.getAttribute("ID");
		
		WebDB		db = null;
		Connection	con = null;
		PreparedStatement		pstmt = null;
		
		try {
			db = new WebDB();
			con = db.getCON();
			String sql = " UPDATE ReBoard SET rb_Title=?, rb_Content=? WHERE rb_NO=?";
			pstmt = db.getPSTMT(con, sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, oriNO);
			pstmt.execute();
			
		} catch (Exception e) {
			System.out.println("댓글 수정 에러 = " + e);
		}
		
		return "/Board/BoardModify.jsp";
	}
}