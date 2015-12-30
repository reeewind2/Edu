package iedu.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.WebDB;

public class BoardDetail implements BoardMain {
	
public String action(HttpServletRequest req, HttpServletResponse resp){
		// 할일
		// 넘어온 파라메터를 받는다.
	String strNO = req.getParameter("oriNO");
	// 실제 사용할 숫자로 변경한다.
	int	oriNO = Integer.parseInt(strNO);
	
	// 지금 보고있는 글의 조회수를 증가할지 여부를 판단한다.
	// 1. 세션이 필요하다.
	HttpSession	session = req.getSession();
	// 2. 이 세션에서 지금까지 봤던 글번호를 꺼낸다.
	// 약속	세션에 지금까지 봤던 글번호는 ("HIT", "글번호들") 로 입력해 놓는다.
	String	hits = (String) session.getAttribute("HIT");
	
	boolean isHit = false;		// 최종 결과를 기억할 변수
	if(hits == null || hits.length() == 0) {
		// 너 지금까지 본 글이 없어
		isHit = true;
		// 이제 이 글을 본것이 되므로 다음을 위해서 세션에 이 글번호를 기억해 놓아야겠다.
		session.setAttribute("HIT", ":" + oriNO + ":");
	}
	else {
		// 본글이 있어
		// 3. 본글 중에서 지금 보고있는 글번호가 있는지 확인한다.
		int temp = hits.indexOf(":" + oriNO + ":");
		if(temp == -1) {
			// 찾을수가 없다.
			isHit = true;
			session.setAttribute("HIT", hits + (":" + oriNO + ":"));
		}
		else {
			// 찾았다.(그 글은 본적이 있다.)
			isHit = false;
		}
	}
	
	// 데이터베이스에서 해당 글을 꺼내서 알려준다.
	WebDB						db = null;
	Connection				con	= null;
	PreparedStatement		pstmt = null;
	ResultSet					rs	= null;
	HashMap					map = new HashMap();
	// 댓글의 최종 정보를 기억할 컬렉션을 준비한다.
	ArrayList					list = new ArrayList();

	
	try {
		db = new WebDB();
		con = db.getCON();
		// 이제 상세보기를 할 예정이므로 조회수를 증가 시켜 주어야겠다.
		String sql = " UPDATE ReBoard SET rb_Hit = rb_Hit + 1 WHERE rb_NO = ?";
		pstmt = db.getPSTMT(con, sql);
		pstmt.setInt(1, oriNO);
		if(isHit == true){
		pstmt.execute();
		}
		
		sql = " SELECT * FROM ReBoard WHERE rb_NO = ?";
		pstmt = db.getPSTMT(con, sql);
		pstmt.setInt(1, oriNO);
		rs = pstmt.executeQuery();
		rs.next();
		// 꺼낸 데이터를 뷰에게 알려준다. 
		// Map으로 만들어서 알려주기로 한다.
		map.put("NO", rs.getInt("rb_NO"));
		map.put("TITLE", rs.getString("rb_Title"));
		map.put("WRITER", rs.getString("rb_Writer"));
		// 본문 내용은 텍스트에리어에서 받아서 데이터베이스에 입력한 내용이므로 줄바꿀 기호가 있
		// 근데 다른 HTML에서는 줄 바꿀 기호를 허락하지 않으므로 줄 바꿀 기호를 <br>로 바꿔야 한다.
		/*map.put("CONTENT", rs.getString("rb_Content") );*/
		String body = rs.getString("rb_Content");
		body = body.replaceAll("\r\n", "<br>");
		map.put("CONTENT", body);
		map.put("DATE", rs.getDate("rb_Date"));
		map.put("HIT", rs.getInt("rb_Hit"));
		db.close(rs);
		
		sql = " SELECT * FROM ReReply WHERE rb_No = ? AND rr_isShow = 'Y' ORDER BY rr_No DESC";
		pstmt = db.getPSTMT(con, sql);
		pstmt.setInt(1, oriNO);
		rs = pstmt.executeQuery();
		// 댓글도 여러개가 있고, 각각의 댓글에는 여러 정보가 있으므로
		// 한줄은 Map으로 묶고 그것을 다시 ArrayList로 묶어서 처리하도록 한다.
		while(rs.next()){
			HashMap		temp = new HashMap();
			temp.put("NO", rs.getShort("rr_NO"));
			temp.put("ORINO", rs.getInt("rb_NO"));
			temp.put("WRITER", rs.getString("rr_Writer"));
			String tempbody = rs.getString("rr_Content");
			tempbody = tempbody.replaceAll("\r\n", "<br>");
			temp.put("BODY", tempbody);
			temp.put("DATE", rs.getDate("rr_Date"));
			
			// 이것을 ArrayList에 넣는다.
			list.add(temp);
			
		}
		
	} catch (Exception e) {
		System.out.println("상세보기 에러 = " + e);
	}
	finally{
		db.close(rs);
		db.close(pstmt);
		db.close(con);
	}
	
	// 처리가 끝났으면
	// 처리 결과중에서 뷰에서 사용할 데이터를 뷰에게 알려주어야 한다.
	
	req.setAttribute("DATA", map);
	req.setAttribute("LIST", list);
	// 뷰를 선택한다.
	
	return "/Board/BoardDetail.jsp";
	
	}
}
